package com.example.stepbystep.ui.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodsMenuViewModel : ViewModel() {

    val foodsMenu: MutableLiveData<List<String>> = MutableLiveData()

    init {
        // Inicializa foodsMenu con una lista vacía
        foodsMenu.value = emptyList()
    }

    fun showRecipe(position: Int) {
        foodsMenu.value = when (position) {
            1 -> listOf("Wilmer", "es", "mka")
            2 -> listOf("lo", "van", "a", "Expulsar")
            else -> listOf("Leche_Asada", "Tarta", "CheeseCake", "Browine")
        }
    }
}
