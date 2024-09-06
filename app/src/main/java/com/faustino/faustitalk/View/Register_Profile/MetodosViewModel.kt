package com.faustino.faustitalk.View.Register_Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MetodosViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val _authState = MutableLiveData<AuthState>()

    // Funcion para completar la primera vista
    fun completeRP1Screen(name: String, apellido: String, username: String) {
        val user = auth.currentUser
        if (user != null) {
            val db = FirebaseFirestore.getInstance()
            val userRef = db.collection("users").document(user.uid)

            val updatedUserMap = mapOf(
                "name" to name,
                "username" to username,
                "apellido" to apellido
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
}
