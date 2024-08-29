package com.faustino.faustitalk.View.Auth.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel:ViewModel() {
    //Para acceder a la autenticaction de firebase 
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
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
            _authState.value=AuthState.Authenticated
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
                    _authState.value = AuthState.Authenticated
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
                    _authState.value = AuthState.Authenticated
                }else{
                    _authState.value = AuthState.Error(task.exception?.message?:"Algo Salio Mal")
                }

            }
    }
    fun signout(){
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

}

sealed class AuthState{
    object Authenticated :AuthState()
    object  Unauthenticated :AuthState()
    object Loading  :AuthState()

    data class  Error(val message : String) :AuthState()
}