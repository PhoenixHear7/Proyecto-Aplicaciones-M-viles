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
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    // Método para obtener la lista de resultados de recetas

    fun showListRecipe(query: String) {
        isLoading.value = true
        viewModelScope.launch {
            // Obtener la lista de resultados de recetas
            val response = RecipesApi.getInstace().showListRecipe(query, 50, "f3bfa1a60ec44532b3c428ca8f27d706", addRecipeInformation = true)
            // Asignar los resultados al LiveData
            recipeResults.value = response.results
            isLoading.value = false

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
