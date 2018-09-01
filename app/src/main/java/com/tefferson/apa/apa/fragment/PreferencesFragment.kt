package com.tefferson.apa.apa.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tefferson.apa.apa.R

/**
 * A simple [Fragment] subclass.
 */
class PreferencesFragment : Fragment() {

    var layout: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        layout = inflater!!.inflate(R.layout.fragment_preferences, container, false)

        return layout
    }
}