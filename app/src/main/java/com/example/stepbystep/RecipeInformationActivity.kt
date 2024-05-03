package com.example.stepbystep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.databinding.ActivityRecipeInformationBinding
import com.example.stepbystep.ui.menu.FoodsMenuViewModel

class RecipeInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeInformationBinding

    private lateinit var viewModel: RecipeInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RecipeInformationViewModel::class.java)
        binding.viewModel = viewModel

        val recipeid = intent.getIntExtra("ID_RECIPE", 0)

    }
}
