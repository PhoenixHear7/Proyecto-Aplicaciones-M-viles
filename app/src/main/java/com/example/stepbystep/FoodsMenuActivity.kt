package com.example.stepbystep

import android.content.Intent
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


        binding.listfood.setOnItemClickListener { parent, view, position, id ->

            val i = Intent(this, RecipeInformationActivity::class.java )

            i.putExtra("RECIPE_INFORMATION", foodsMenu[position])
            i.putExtra("RECIPE_IMAGE", foodsMenu[position].lowercase())

            startActivity(i)



        }



    }

}