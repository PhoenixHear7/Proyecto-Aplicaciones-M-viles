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

        // Enlazar ViewModel con el layout
        binding.viewModel = viewModel

        // Obtener el nombre de la comida seleccionada
        val dailyFoodName = intent.getStringExtra("DAILY_FOOD_NAME")
        binding.dailyFoodsName.text = dailyFoodName

        val query = binding.dailyFoodsName.text.toString()



        // Llamar al método para cargar la lista de recetas con el valor de la daily food
        viewModel.showListRecipe(query)

        // Inicializar el adaptador con una lista vacía
        adapter = FoodsMenuAdapter(this, R.layout.activity_foodsmenu_list, ArrayList())
        binding.listfood.adapter = adapter

        // Observar los cambios en la lista de recetas y actualizar el adaptador
        viewModel.recipeResults.observe(this) { recipeResults ->
            // Extraer la lista de recetas del MutableLiveData y pasarla al adaptador
            adapter.updateRecipes(recipeResults)
        }
     binding.listfood.setOnItemClickListener { parent, view, position, id ->
         viewModel.getIdRecipe(position)

     }
        viewModel.idRecipe.observe(this){ idRecipe ->

            val i = Intent(this, RecipeInformationActivity:: class.java )
            i.putExtra("ID_RECIPE",idRecipe)
            startActivity(i)


        }
    }
}
