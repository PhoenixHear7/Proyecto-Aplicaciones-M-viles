package com.example.stepbystep.ui.menu

import RecipeResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stepbystep.ui.RecipesApi
import kotlinx.coroutines.launch

class FoodsMenuViewModel : ViewModel() {

    // LiveData para la lista de resultados de recetas
    val recipeResults: MutableLiveData<List<RecipeResult>> = MutableLiveData()
    val idRecipe: MutableLiveData<Int> = MutableLiveData()
    val recipesDescrion: MutableLiveData<List<RecipeResult>> = MutableLiveData()

    // Método para obtener la lista de resultados de recetas
    fun showListRecipe(query: String) {
        viewModelScope.launch {
            // Obtener la lista de resultados de recetas
            val response = RecipesApi.getInstace().showListRecipe(query, 50, "51bcdba4a84d4bf9ad9caed2512dbb39", addRecipeInformation = true)
            // Asignar los resultados al LiveData
            recipeResults.value = response.results


        }
    }

    fun getIdRecipe(position: Int) {
        val results = recipeResults.value
        if (results != null && position in results.indices) {
            val id = results[position].id
            idRecipe.value = id
        }
    }


}
