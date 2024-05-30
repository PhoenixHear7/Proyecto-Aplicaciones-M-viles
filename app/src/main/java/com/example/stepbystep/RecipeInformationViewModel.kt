package com.example.stepbystep

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stepbystep.ui.RecipesApi
import com.example.stepbystep.ui.menu.FoodsMenuViewModel
import kotlinx.coroutines.launch


class RecipeInformationViewModel: ViewModel()  {

    val name: MutableLiveData<String> = MutableLiveData()

    val url: MutableLiveData<String> = MutableLiveData()
    val instructions: MutableLiveData<String> = MutableLiveData()
    val ingredients:MutableLiveData<List<String>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun recipeInfo(id:Int){

        isLoading.value = true  // progressBar

        viewModelScope.launch {
            val response = RecipesApi.getInstace().showDescripcion(id, "f3bfa1a60ec44532b3c428ca8f27d706")

            name.value = response.title
            url.value = response.image

            val separatedInstructions = response.instructions.split(Regex("</li><li>|<ol><li>|</li></ol>|\\."))
            val formattedInstructions = separatedInstructions
                .filter { it.isNotBlank() } // Filtrar las líneas en blanco
                .joinToString("\n") { "• $it" }

            instructions.value = formattedInstructions

            val ingredientNames = response.extendedIngredients.map { it.name }
            ingredients.value = ingredientNames
            isLoading.value = false  // Ocultar ProgressBar
        }

    }
}