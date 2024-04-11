package com.example.stepbystep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepbystep.databinding.ActivityFoodsMenuBinding

class FoodsMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFoodsMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodsMenu = arrayListOf<String>("Leche_Asada", "Tarta", "CheeseCake", "Browine")

        val adapter = FoodsMenuAdapter(this, R.layout.activity_foodsmenu_list, foodsMenu)

        binding.listfood.adapter = adapter
    }
}