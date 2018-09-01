package com.tefferson.apa.apa.adapter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tefferson.apa.apa.R
import com.tefferson.apa.apa.enumeration.DeafnessDegree

/**
 * Created by teffe on 27/08/2018.
 */
class DeafnessDegreeAdapter(context: Context, items: List<DeafnessDegree>, private val activity: AppCompatActivity)
    : ArrayAdapter<DeafnessDegree>(context, R.layout.item_deafness_degree, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layout = LayoutInflater.from(context)
                .inflate(R.layout.item_deafness_degree, parent, false)

        initElements(layout, position)

        return layout
    }

    private fun initElements(layout: View?, position: Int) {

        val item = getItem(position)
        val tvDeafnessDegree = layout?.findViewById<TextView>(R.id.tv_deafness_degree)

        tvDeafnessDegree?.text = item.label
        tvDeafnessDegree?.setCompoundDrawablesWithIntrinsicBounds(item.iconResId, 0, 0, 0)
    }
}