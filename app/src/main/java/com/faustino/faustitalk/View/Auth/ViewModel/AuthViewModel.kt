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
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


const val WEB_CLIENT_ID = "789640903345-0ehtnjqpqnbipc10knt0o1meebovntpo.apps.googleusercontent.com"


class AuthViewModel:ViewModel() {
    //Para acceder a la autenticaction de firebase 
    private val auth : FirebaseAuth = Firebase.auth
    //datos mutables que solo se exponen con liveData (imutable)
    private val _authState  = MutableLiveData<AuthState>()
    //Permite ver los cambios de _authstate
    val authState :LiveData<AuthState> =_authState

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus(){
        if (auth.currentUser ==null){
            _authState.value=AuthState.Unauthenticated
        }else{
            //_authState.value=AuthState.Authenticated
            checkUserProfile() // validacion
        }
    }

    fun login(email:String, password :String){

        if (email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("El correo y la contraseña no pueden estar vacios")
            return
        }
        _authState.value = AuthState.Loading

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){
                    checkUserProfile() // Validar perfil después de autenticar
                    //_authState.value = AuthState.Authenticated
                }else{
                    _authState.value = AuthState.Error(task.exception?.message?:"Algo Salio Mal")
                }

            }
    }

    fun signup(email:String, password :String){

        if (email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("El correo y la contraseña no pueden estar vacios")
            return
        }
        _authState.value = AuthState.Loading

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){

                    val user = auth.currentUser // obtener usuario actual
                    if (user != null) {
                        createUserDocument(user.uid, email) // crea usuario con el uid
                        _authState.value = AuthState.IncompleteProfile
                    }
                    //_authState.value = AuthState.Authenticated
                }else{
                    _authState.value = AuthState.Error(task.exception?.message?:"Algo Salio Mal")
                }

            }
    }

    fun signout(){
        _authState.value = AuthState.Unauthenticated
        auth.signOut()

    }


    //Cuando un usuario se registra por primera vez, crea un documento en la colección users con su UID y cualquier otra información inicial que necesites
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


    //verifica si el perfil está completo al intentar acceder a la vista de inicio
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


    //completa la información y luego actualiza el documento en Firestore
    fun completeUserProfile(name: String, surname: String, username: String) {
        val user = auth.currentUser
        if (user != null) {
            val db = FirebaseFirestore.getInstance()
            val userRef = db.collection("users").document(user.uid)

            val updatedUserMap = mapOf(
                "surname" to surname,
                "name" to name,
                "apellido" to "",
                "fecha_nacimiento" to "",
                "genero" to "",
                "tipoperfil" to "",
                "descripcion" to "",
                "profileComplete" to false

            )

            userRef.update(updatedUserMap)
                .addOnSuccessListener {
                    _authState.value = AuthState.Authenticated
                }
                .addOnFailureListener { e ->
                    _authState.value = AuthState.Error("Error al actualizar el perfil: ${e.message}")
                }
        }
    }



    fun LoginToGoogle( context: Context, scope : CoroutineScope){
        _authState.value = AuthState.Loading
        // val sope = rememberCoroutineScope()
        val credentialManager = CredentialManager.create(context)


        //  val starDestination = if (auth.currentUser == null)

        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(WEB_CLIENT_ID)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        scope.launch {
            try {
                val result = credentialManager.getCredential(
                    context = context,
                    request = request
                )
                val credential = result.credential
                val googleIdTokenCredential = GoogleIdTokenCredential
                    .createFrom(credential.data)
                val googleIdToken = googleIdTokenCredential.idToken

                val firebaseCredential =
                    GoogleAuthProvider.getCredential(googleIdToken,null)
                auth.signInWithCredential(firebaseCredential)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){

                                val user = auth.currentUser
                                if (user != null){
                                    val db = FirebaseFirestore.getInstance()
                                    val userRef = db.collection("users").document(user.uid)

                                    userRef.get().addOnSuccessListener { document ->
                                        if (document.exists()) {
                                            // Si el documento existe, verifica si el perfil está completo
                                            val isProfileComplete = document.getBoolean("profileComplete") ?: false
                                            if (isProfileComplete) {
                                                _authState.value = AuthState.Authenticated
                                            } else {
                                                _authState.value = AuthState.IncompleteProfile
                                            }
                                        } else {
                                            // Si el documento no existe, crea uno nuevo
                                            createUserDocument(user.uid, user.email ?: "")
                                        }
                                    }.addOnFailureListener {
                                        _authState.value = AuthState.Error("Error al obtener la información del usuario")
                                    }
                                }


                            Toast.makeText(
                                context,
                                "Iniciando con ${auth.currentUser?.displayName}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }.addOnFailureListener { e ->

                    }
            }catch (e : Exception){
                if (e is GetCredentialException) {
                    // El usuario canceló o ocurrió un error
                    // Log.e(TAG, "Autenticación cancelada o error: ${e.message}")
                    _authState.value = AuthState.Unauthenticated
                    Toast.makeText(context, "Autenticación cancelada.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        context,
                        "Error: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    e.printStackTrace()
                }

                //   _authState.value = AuthState.Error(e.message?:"Ocurrio algun error")
            }

        }

    }





}

sealed class AuthState{
    object Authenticated :AuthState()
    object  Unauthenticated :AuthState()
    object Loading  :AuthState()

    object IncompleteProfile : AuthState()  // Nuevo estado

    data class  Error(val message : String) :AuthState()
}