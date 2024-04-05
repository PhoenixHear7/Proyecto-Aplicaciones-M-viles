package com.example.stepbystep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stepbystep.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dailyFoodsName = arrayListOf<String>("Breakfast", "Dinner", "Desserts")

        val adapter = DailyFoodsAdapter(this, R.layout.activity_list_daily_food, dailyFoodsName)

        binding.ListsFoods.adapter = adapter
    }
}