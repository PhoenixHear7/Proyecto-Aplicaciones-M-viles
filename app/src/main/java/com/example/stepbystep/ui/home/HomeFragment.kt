package com.example.stepbystep.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stepbystep.DailyFoodsAdapter
import com.example.stepbystep.FoodsMenuActivity
import com.example.stepbystep.R
import com.example.stepbystep.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dailyFoodsName = arrayListOf<String>("Breakfast", "Dinner", "Desserts")

        val adapter = DailyFoodsAdapter(requireActivity(), R.layout.activity_list_daily_food, dailyFoodsName)

        binding.ListsFoods.adapter = adapter


        binding.ListsFoods.setOnItemClickListener { parent, view, position, id ->


            val i = Intent(requireActivity(), FoodsMenuActivity::class.java)
            startActivity(i)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}