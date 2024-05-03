package com.example.stepbystep.ui.menu

import RecipeResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stepbystep.ui.RecipesApi
import kotlinx.coroutines.launch
import java.text.FieldPosition

class FoodsMenuViewModel : ViewModel() {

    // LiveData para la lista de resultados de recetas
    val recipeResults: MutableLiveData<List<RecipeResult>> = MutableLiveData()
    val idRecipe: MutableLiveData<Int> = MutableLiveData()
    fun getidRecipe(position: Int){
        val listResult = recipeResults.value

        //  Verifica que las lista no sea nula, y que la posicion
        //  recibida sea igual al inidice de la lista
        if (listResult != null && position in listResult.indices) {
            val id = listResult[position].id
            idRecipe.value = id
        }

    }
    // Método para obtener la lista de resultados de recetas
    fun showListRecipe(query: String) {
        viewModelScope.launch {

            // Obtener la lista de resultados de recetas
            val response = RecipesApi.getInstace().showImageRecipe(query, 50, "2b0ba9cc4e7444eda6e58adecb9caf84")
            // Asignar los resultados al LiveData
            recipeResults.value = response.results


        }
    }

}