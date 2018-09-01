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
class NotificationsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_notifications, container, false)
    }

}