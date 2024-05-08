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

    fun recipeInfo(id:Int){

        viewModelScope.launch {


            val response = RecipesApi.getInstace().showDescripcion(id, "2b0ba9cc4e7444eda6e58adecb9caf84")

            name.value = response.title
            url.value = response.image
            instructions.value = response.instructions
        }

    }
}