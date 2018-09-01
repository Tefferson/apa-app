package com.tefferson.apa.apa.util

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem

/**
 * Created by teffe on 26/08/2018.
 */
object BottomNavigationUtil {

    fun getSelectedOrder(bottomNavigationView: BottomNavigationView, menuItem: MenuItem) : Int {

        val menu = bottomNavigationView.menu
        for(i in 0..(menu.size() - 1)) {
            val item = menu.getItem(i)
            if(item.itemId == menuItem.itemId) {
                return i
            }
        }
        return -1
    }
}