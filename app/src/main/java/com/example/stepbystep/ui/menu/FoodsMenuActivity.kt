package com.example.stepbystep.ui.menu


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepbystep.R
import com.example.stepbystep.RecipeInformationActivity
import com.example.stepbystep.databinding.ActivityFoodsMenuBinding
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.FoodsMenuAdapter



class FoodsMenuActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodsMenuViewModel
    private lateinit var adapter: FoodsMenuAdapter
    private lateinit var binding: ActivityFoodsMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodsMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el ViewModel
        viewModel = ViewModelProvider(this).get(FoodsMenuViewModel::class.java)


    }
}



