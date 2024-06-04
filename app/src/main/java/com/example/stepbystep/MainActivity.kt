package com.example.stepbystep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.stepbystep.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)



        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()




        // utilizamos el binding para que al seleccionar al opcion sign nos envie a la actividad de esta
        binding.singupButton.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
        // utilizamos el binding para que al seleccionar la opcion log in sign nos envie a la actividad de esta

        binding.loginButton.setOnClickListener {


            val username = binding.userame.text.toString()
            val password = binding.editTextTextPassword.text.toString()

// Realizar una consulta para buscar un usuario con el nombre de usuario o correo electrónico proporcionados
            db.collection("users")
                .whereEqualTo("username", username)
                .whereEqualTo("password", password)
                .get()
                .addOnSuccessListener { documents ->
                    if (documents.isEmpty) {
                        // No se encontró ningún usuario con las credenciales proporcionadas, mostrar un mensaje de error
                        Toast.makeText(this, "Nombre o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    } else {
                        // Se encontró un usuario con las credenciales proporcionadas, permitir iniciar sesión
                        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                        val i = Intent(this, FragmentActivity::class.java)
                        startActivity(i)
                        // Aquí puedes dirigir al usuario a la pantalla principal o realizar otras acciones necesarias
                    }
                }
                .addOnFailureListener { exception ->
                    Log.e("Firestore", "Error al iniciar sesión: $exception")
                }
        }

        binding.forgotPassword.setOnClickListener {
            val i = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(i)
        }
    }


}