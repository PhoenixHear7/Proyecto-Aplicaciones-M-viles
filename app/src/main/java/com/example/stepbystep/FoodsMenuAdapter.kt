package com.example.stepbystep

import RecipeResult
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class FoodsMenuAdapter(val context: Activity, val layout: Int, val data: ArrayList<RecipeResult>)
    : ArrayAdapter<RecipeResult>(context, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(layout, null)
        val name = view.findViewById<TextView>(R.id.foodsname)
        val img = view.findViewById<ImageView>(R.id.foodsimage)

        val recipe = data[position]
        name.text = recipe.title
        showImage(recipe.image, img)

        return view
    }

    fun updateRecipes(recipeList: List<RecipeResult>) {
        // Limpiar la lista actual
        data.clear()
        data.addAll(recipeList)
        notifyDataSetChanged()
    }

    fun showImage(url: String, imageView: ImageView) {
            Picasso.get()
                .load(url)
                .into(imageView)

    }



}

