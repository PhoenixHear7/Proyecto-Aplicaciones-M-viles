package com.example.stepbystep

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.databinding.ActivityRecipeInformationBinding
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

        // Pasamos el id de la receta seleccionada al ViewModel
        viewModel.recipeInfo(recipeId)

        // Observadores para actualizar la UI
        viewModel.name.observe(this) { name ->
            binding.recipeName.text = name
        }

        viewModel.url.observe(this) { url ->
            showImage(url)
        }

        viewModel.instructions.observe(this) { instructions ->
            binding.instructions.text = instructions
        }


        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.ingredients.observe(this) { ingredients ->
            updateIngredientsGrid(ingredients)
        }
    }

    private fun showImage(url: String) {
        Picasso.get()
            .load(url)
            .resize(4000, 2000)
            .into(binding.recipeImage)
    }

    private fun updateIngredientsGrid(ingredients: List<String>) {
        val gridLayout = binding.gridLayoutIngredients
        gridLayout.removeAllViews()

        val columnCount = 2 // Define el número de columnas
        val rowCount = (ingredients.size + columnCount - 1) / columnCount

        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                val index = i * columnCount + j
                if (index < ingredients.size) {
                    val ingredient = ingredients[index]
                    val textView = TextView(this)
                    textView.text = "- $ingredient" // Agregar el prefijo numérico
                    textView.setTextColor(getColor(R.color.white))
                    textView.textSize = 20f
                    textView.setPadding(10, 10, 10, 10)

                    val params = GridLayout.LayoutParams()
                    params.rowSpec = GridLayout.spec(i)
                    params.columnSpec = GridLayout.spec(j)
                    params.setMargins(10, 10, 10, 10)

                    textView.layoutParams = params
                    gridLayout.addView(textView)
                }
            }
        }
    }
}
