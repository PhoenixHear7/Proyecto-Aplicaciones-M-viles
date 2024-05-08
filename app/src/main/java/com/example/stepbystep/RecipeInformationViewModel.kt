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

    fun recipeInfo(id:Int){

        viewModelScope.launch {


            val response = RecipesApi.getInstace().showDescripcion(id, "51bcdba4a84d4bf9ad9caed2512dbb39")

            name.value = response.title
            url.value = response.image
            instructions.value = response.instructions
            val separatedInstructions = response.instructions.split("</li><li>")
            instructions.value = separatedInstructions.toString()
            val ingredientNames = response.extendedIngredients.map { it.name }
            ingredients.value = ingredientNames
        }

    }
}