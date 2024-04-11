package com.example.stepbystep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepbystep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // utilizamos el binding para que al seleccionar al opcion sign nos envie a la actividad de esta
         binding.singupButton.setOnClickListener {
             val i = Intent(this, FoodsMenuActivity::class.java)
             startActivity(i)
         }
        // utilizamos el binding para que al seleccionar la opcion log in sign nos envie a la actividad de esta

        binding.loginButton.setOnClickListener {
            val i = Intent(this, FragmentActivity::class.java)
            startActivity(i)
        }

        binding.forgotPassword.setOnClickListener {
            val i = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(i)
        }
    }


}