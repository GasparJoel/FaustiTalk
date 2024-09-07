import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faustino.faustitalk.View.Auth.ViewModel.AuthState
import com.faustino.faustitalk.View.Register_Profile.User
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

    private val userC = User()

    fun completeRP1Screen(name: String, apellido: String, username: String) {
        userC.setUsername(username)
        userC.setNombre(name)
        userC.setApellido(apellido)
    }
    fun completeRP2Screen(fechaNacimiento: String, genero: String) {
        userC.setFechaNac(fechaNacimiento)
        userC.setGenero(genero)
    }
    fun completeRP3Screen(tipoPerfil: String){
        userC.setTipoPerfil(tipoPerfil)
    }

    fun crearUsuario(){
        val user = auth.currentUser
        if(user != null){
            val userRef = db.collection("users").document(user.uid)
            val updatedUserMap = mapOf(
                "apellido" to userC.getApellido(),
                "descripcion" to "",
                "email" to userC.getEmail(),
                //"fecha_nacimiento" to userC.getFechaNac(),
                "fecha_nacimiento" to "06-09-2024",
                "genero" to userC.getGenero(),
                "name" to userC.getNombre(),
                "profileComplete" to true, //Se actualiza a Perfil creado
                "tipoperfil" to userC.getTipoPerfil(),
                "username" to userC.getUsername(),
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
