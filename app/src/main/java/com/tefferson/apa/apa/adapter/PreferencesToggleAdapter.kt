package com.tefferson.apa.apa.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.tefferson.apa.apa.R
import com.tefferson.apa.apa.model.PreferencesToggleItem

/**
 * Created by teffe on 26/08/2018.
 */
class PreferencesToggleAdapter(context: Context, items: List<PreferencesToggleItem>, private val activity: AppCompatActivity)
    : ArrayAdapter<PreferencesToggleItem>(context, R.layout.item_preferences_toggle, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layout = LayoutInflater.from(context)
                .inflate(R.layout.item_preferences_toggle, parent, false)

        initElements(layout, position)

        return layout
    }

    private fun initElements(layout: View?, position: Int) {

        val item = getItem(position)
        val tvPreference = layout?.findViewById<TextView>(R.id.tv_preference)
        val ivPreference = layout?.findViewById<ImageView>(R.id.iv_preference)
        val cbPreference = layout?.findViewById<CheckBox>(R.id.cb_preference)

        layout?.setOnClickListener { _ ->
            run {
                cbPreference?.toggle()
            }
        }

        tvPreference?.text = item.label
        ivPreference?.setColorFilter(ContextCompat.getColor(context, item.resColorId))
        ivPreference?.setImageResource(item.resId)
    }
}