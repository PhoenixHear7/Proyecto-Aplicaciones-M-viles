package com.example.stepbystep

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel : ViewModel() {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val _registerResult = MutableLiveData<Result<String>>()
    val registerResult: LiveData<Result<String>> = _registerResult

    fun registerUser(username: String, email: String, password: String) {
        if (!isValidEmail(email)) {
            _registerResult.value = Result.failure(Exception("El correo electrónico no es válido"))
            return
        }

        // Verificar si el nombre de usuario ya existe
        db.collection("users")
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    // Nombre de usuario disponible, proceder con el registro
                    val user = hashMapOf(
                        "username" to username,
                        "email" to email,
                        "password" to password
                    )

                    // Guardar los datos en Firestore
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d("Firestore", "Documento agregado con éxito: $documentReference")
                            _registerResult.value = Result.success("Usuario registrado con éxito")
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firestore", "Error al agregar documento: ${e.message}", e)
                            _registerResult.value = Result.failure(e)
                        }
                } else {
                    // Nombre de usuario ya existe
                    _registerResult.value = Result.failure(Exception("El nombre de usuario ya está en uso"))
                }
            }
            .addOnFailureListener { e ->
                _registerResult.value = Result.failure(e)
            }
    }

    // Función para validar el formato del correo electrónico usando expresiones regulares
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}