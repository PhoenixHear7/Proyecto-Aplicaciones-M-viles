package com.example.stepbystep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.databinding.ActivityRecipeInformationBinding
import com.example.stepbystep.ui.menu.FoodsMenuViewModel
import com.squareup.picasso.Picasso

class RecipeInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeInformationBinding

    private lateinit var viewModel: RecipeInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RecipeInformationViewModel::class.java)
        binding.viewModel = viewModel

        val recipeId = intent.getIntExtra("ID_RECIPE", 0)

        binding.viewModel = viewModel

        //pasamos el id de la receta seleccionada al viewModel
        viewModel.recipeInfo(recipeId)

        //ponemos un observadir para cuando el texto cambie este se refleje en la vista, lo mismo para la url y la instrucciones
        viewModel.name.observe(this){name ->
            binding.recipeName.text = name
        }

        viewModel.url.observe(this){url ->
            shoeImage(url)
        }

        viewModel.instructions.observe(this){url ->
            binding.instructions.text = url
        }

        viewModel.ingredients.observe(this){ingredents ->
            binding.TEXTIngredient.text = ingredents.toString()
        }

    }



    fun shoeImage(url: String){

        Picasso.get()
            .load(url)
            .resize(4000, 2000)
            .into(binding.recipeImage)
    }
}
