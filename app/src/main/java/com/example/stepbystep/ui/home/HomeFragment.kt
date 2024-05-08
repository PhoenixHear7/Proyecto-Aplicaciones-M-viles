package com.example.stepbystep.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.DailyFoodsAdapter
import com.example.stepbystep.R
import com.example.stepbystep.databinding.FragmentHomeBinding
import com.example.stepbystep.ui.menu.FoodsMenuActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel
    private val binding get() = _binding!!

    val dailyFoodsName = arrayListOf<String>("Breakfast", "Dinner", "Desserts")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.searchEditText.setOnClickListener {
            val search = binding.searchEditText.text.toString()
                 if (search.isNotEmpty()) {
                     val i = Intent(requireActivity(), FoodsMenuActivity::class.java)
                     i.putExtra("DAILY_FOOD_NAME", search.capitalize())
                     startActivity(i)
                }
            }


        showListFood()

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun showListFood() {

        val adapter = DailyFoodsAdapter(requireActivity(), R.layout.activity_list_daily_food, dailyFoodsName)
        binding.ListsFoods.adapter = adapter
        binding.ListsFoods.setOnItemClickListener { parent, view, position, id ->

            val i = Intent(requireActivity(), FoodsMenuActivity::class.java)
            i.putExtra("DAILY_FOOD_NAME", dailyFoodsName[position])
            startActivity(i)

        }
    }

}

