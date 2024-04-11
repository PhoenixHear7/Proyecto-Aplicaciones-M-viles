package com.example.stepbystep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepbystep.databinding.ActivityRecipeInformationBinding

class RecipeInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeName = intent.getStringExtra("RECIPE_INFORMATION")
        val  image =  intent.getStringExtra("RECIPE_IMAGE")
        val recipeImage = resources.getIdentifier(image, "drawable", packageName)

        binding.recipeImage.setImageResource(recipeImage)

        binding.recipeName.text = recipeName
    }
}
