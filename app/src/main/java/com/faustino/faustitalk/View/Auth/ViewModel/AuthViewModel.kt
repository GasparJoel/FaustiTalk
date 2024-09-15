package com.faustino.faustitalk.View.Auth.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

const val WEB_CLIENT_ID = "789640903345-0ehtnjqpqnbipc10knt0o1meebovntpo.apps.googleusercontent.com"

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.Unauthenticated
        } else {
            checkUserProfile()
        }
    }

    fun checkUserProfile() {
        val user = auth.currentUser
        if (user != null) {
            val db = FirebaseFirestore.getInstance()
            val userRef = db.collection("users").document(user.uid)

            userRef.get().addOnSuccessListener { document ->
                if (document.exists()) {
                    val isProfileComplete = document.getBoolean("profileComplete") ?: false
                    if (isProfileComplete) {
                        _authState.value = AuthState.Authenticated
                    } else {
                        _authState.value = AuthState.IncompleteProfile
                    }
                } else {
                    _authState.value = AuthState.Error("Perfil del usuario no encontrado")
                }
            }.addOnFailureListener {
                _authState.value = AuthState.Error("Error al obtener la información del usuario")
            }
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("El correo y la contraseña no pueden estar vacíos")
            return
        }
        _authState.value = AuthState.Loading

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    checkUserProfile()
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Algo salió mal")
                }
            }
    }

    fun signup(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("El correo y la contraseña no pueden estar vacíos")
            return
        }
        _authState.value = AuthState.Loading

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        createUserDocument(user.uid, email)
                        _authState.value = AuthState.IncompleteProfile
                    }
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Algo salió mal")
                }
            }
    }

    fun signout() {
        _authState.value = AuthState.Unauthenticated
        auth.signOut()
    }

    private fun createUserDocument(uid: String, email: String) {
        val db = FirebaseFirestore.getInstance()
        val userMap = hashMapOf(
            "email" to email,
            "username" to "",
            "name" to "",
            "apellido" to "",
            "fecha_nacimiento" to "",
            "genero" to "",
            "tipoperfil" to "",
            "descripcion" to "",
            "profileComplete" to false
        )

        db.collection("users").document(uid)
            .set(userMap)
            .addOnSuccessListener {
                _authState.value = AuthState.IncompleteProfile
            }
            .addOnFailureListener { e ->
                _authState.value = AuthState.Error("Error al crear el perfil del usuario: ${e.message}")
            }
    }

    fun LoginToGoogle(context: Context, scope: CoroutineScope) {
        _authState.value = AuthState.Loading
        val credentialManager = CredentialManager.create(context)
        val signInWithGoogleOption = GetSignInWithGoogleOption.Builder(WEB_CLIENT_ID).build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(signInWithGoogleOption)
            .build()

        scope.launch {
            try {
                val result = credentialManager.getCredential(context = context, request = request)
                val credential = result.credential
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                val googleIdToken = googleIdTokenCredential.idToken

                auth.signOut()
                val firebaseCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
                auth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            if (user != null) {
                                val email = user.email ?: ""
                                if (email.endsWith("@unjfsc.edu.pe")) {
                                    val db = FirebaseFirestore.getInstance()
                                    val userRef = db.collection("users").document(user.uid)

                                    userRef.get().addOnSuccessListener { document ->
                                        if (document.exists()) {
                                            val isProfileComplete = document.getBoolean("profileComplete") ?: false
                                            if (isProfileComplete) {
                                                _authState.value = AuthState.Authenticated
                                            } else {
                                                _authState.value = AuthState.IncompleteProfile
                                            }
                                        } else {
                                            createUserDocument(user.uid, user.email ?: "")
                                        }
                                    }.addOnFailureListener {
                                        _authState.value = AuthState.Error("Error al obtener la información del usuario")
                                    }
                                } else {
                                    auth.signOut()
                                    _authState.value = AuthState.Unauthenticated
                                    Toast.makeText(context, "Solo se permiten correos de @unjfsc.edu.pe", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }.addOnFailureListener { e ->
                        _authState.value = AuthState.Error("Error de autenticación: ${e.message}")
                    }
            } catch (e: Exception) {
                if (e is GetCredentialException) {
                    _authState.value = AuthState.Unauthenticated
                    Toast.makeText(context, "Autenticación cancelada.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
        }
    }
}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    object IncompleteProfile : AuthState()
    data class Error(val message: String) : AuthState()
}
