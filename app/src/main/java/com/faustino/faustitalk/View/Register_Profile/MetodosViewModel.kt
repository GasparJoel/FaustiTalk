import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MetodosViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    private val _userData = MutableLiveData<Map<String, Any>>()
    val userData: LiveData<Map<String, Any>> = _userData

    fun completeRP1Screen(name: String, apellido: String, username: String) {
        val user = auth.currentUser
        if (user != null) {
            val userRef = db.collection("users").document(user.uid)
            val updatedUserMap = mapOf(
                "name" to name,
                "username" to username,
                "apellido" to apellido
            )
            userRef.update(updatedUserMap)
                .addOnSuccessListener {
                    _authState.value = AuthState.Unauthenticated
                }
                .addOnFailureListener { e ->
                    _authState.value = AuthState.Error("Error al actualizar el perfil: ${e.message}")
                }
        }
    }

    fun fetchUserData() {
        val user = auth.currentUser
        if (user != null) {
            val userRef = db.collection("users").document(user.uid)
            userRef.get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        _userData.value = document.data ?: emptyMap()
                    } else {
                        _userData.value = emptyMap()
                    }
                }
                .addOnFailureListener { e ->
                    _userData.value = emptyMap()
                }
        }

    }
}
