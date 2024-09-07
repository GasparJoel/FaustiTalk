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
    fun completeRPUni1Screen(facultad:String, escuela:String, ciclo:String){
        userC.setUniversitario(facultad,escuela,ciclo)
    }
    fun completeRPDocSreen(especialidad:String){
        userC.setEspecialidad(especialidad)
    }
    fun CompleteRP4Screen(intereses: List<String>) {
        for (interes in intereses) {
            userC.addInteres(interes) // Agrega cada interés al arreglo
        }
    }

    fun crearUsuario() {
        val user = auth.currentUser
        if (user != null) {
            val userRef = db.collection("users").document(user.uid)
            val updatedUserMap = mapOf(
                "email" to user.email,
                "username" to userC.getUsername(),
                "name" to userC.getNombre(),
                "apellido" to userC.getApellido(),
                "fecha_nacimiento" to userC.getFechaNac(),
                "genero" to userC.getGenero(),
                "tipoperfil" to userC.getTipoPerfil(),
                "descripcion" to "",
                "profileComplete" to true // Se actualiza a Perfil creado
            )

            // Actualiza el documento del usuario
            userRef.update(updatedUserMap)
                .addOnSuccessListener {
                    // Obtener el tipo de perfil
                    val tipoPerfil = userC.getTipoPerfil()

                    // Validar si es 'Universitario' o 'Docente'/'Administrativo'
                    if (tipoPerfil == "Universitario") {
                        // Crear subcolección 'Universitario' con las propiedades facultad, escuela y ciclo usando el mismo uid
                        val universitarioData = mapOf(
                            "facultad" to userC.getFacultad(),
                            "escuela" to userC.getEscuela(),
                            "ciclo" to userC.getCiclo()
                        )
                        userRef.collection("Universitario").document(user.uid).set(universitarioData)
                    } else if (tipoPerfil == "Docente" || tipoPerfil == "Administrativo") {
                        // Crear subcolección 'Docente' o 'Administrativo' con la propiedad especialidad usando el mismo uid
                        val data = mapOf(
                            "especialidad" to userC.getEspecialidad()
                        )
                        userRef.collection(tipoPerfil).document(user.uid).set(data)
                    }

                    // Crear la subcolección 'Intereses' usando el mismo uid
                    val intereses = userC.getIntereses() // Supongamos que esto devuelve una lista de intereses
                    val interesesData = intereses.mapIndexed { index, interes ->
                        "interes${index + 1}" to interes
                    }.toMap()

                    userRef.collection("Intereses").document(user.uid).set(interesesData)
                        .addOnSuccessListener {
                            _authState.value = AuthState.Authenticated
                        }
                        .addOnFailureListener { e ->
                            _authState.value = AuthState.Error("Error al almacenar intereses: ${e.message}")
                        }
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
