package com.example.stepbystep

import android.app.Activity
import android.hardware.biometrics.BiometricManager.Strings
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DailyFoodsAdapter(val context: Activity,val layout: Int, val data: ArrayList<String>)
    : ArrayAdapter<String>(context,layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(layout, null)
        val name = view.findViewById<TextView>(R.id.foodName)
        name.text= data[position]
        val imageID = context.resources.getIdentifier(data[position].lowercase(), "drawable", context.packageName)
        val img = view.findViewById<ImageView>(R.id.imagefood)
        img.setImageResource(imageID)
        return view
    }
}