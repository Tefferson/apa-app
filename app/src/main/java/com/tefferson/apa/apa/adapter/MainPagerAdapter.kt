package com.tefferson.apa.apa.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Spinner
import com.tefferson.apa.apa.R
import com.tefferson.apa.apa.enumeration.DeafnessDegree
import com.tefferson.apa.apa.enumeration.MainPager
import com.tefferson.apa.apa.model.NotificationItem
import com.tefferson.apa.apa.model.PreferencesToggleItem
import java.util.*

/**
 * Created by teffe on 26/08/2018.
 */
class MainPagerAdapter(private val context: Context,
                       private val viewPager: ViewPager,
                       private val activity: AppCompatActivity) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view === `object`
    override fun getCount(): Int = MainPager.values().size

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val mainPager = MainPager.values()[position]

        val layout = LayoutInflater.from(context)
                .inflate(mainPager.layoutResId, container, false)

        container?.addView(layout)

        when (mainPager.layoutResId) {
            R.layout.fragment_notifications -> initNotificationsElements(layout)
            R.layout.fragment_main -> initMainElements(layout)
            R.layout.fragment_preferences -> initPreferencesElements(layout)
        }



        return layout
    }

    private fun initNotificationsElements(layout: View?) {
        val lvNotifications = layout?.findViewById<ListView>(R.id.lv_notifications)

        val items = ArrayList<NotificationItem>()
        items.add(NotificationItem("Sala de estar", "Sons altos", R.mipmap.sofa, R.mipmap.question_mark, Date()))
        items.add(NotificationItem("Cozinha", "Estilhaços de vidro", R.mipmap.stove, R.mipmap.break_glass, Date()))
        items.add(NotificationItem("Sala de estar", "Porta batendo", R.mipmap.sofa, R.drawable.ic_highlight_black_24dp, Date()))

        val adapter = NotificationAdapter(context, items, activity)
        lvNotifications?.adapter = adapter
    }

    private fun initMainElements(layout: View?) {
        val spinnerMain = layout?.findViewById<Spinner>(R.id.spinner_main)

        val adapter = DeafnessDegreeAdapter(context, DeafnessDegree.values().asList(), activity)
        adapter.setDropDownViewResource(R.layout.item_deafness_degree)
        spinnerMain?.adapter = adapter
    }

    private fun initPreferencesElements(layout: View?) {
        val lvPreferencesToggle = layout?.findViewById<ListView>(R.id.lv_preferences_toggle)

        val items = ArrayList<PreferencesToggleItem>()
        items.add(PreferencesToggleItem("Receber SMS", R.drawable.ic_sms_black_24dp, R.color.colorGreen))
        items.add(PreferencesToggleItem("Receber e-mail", R.drawable.ic_email_black_24dp, R.color.colorRed))
        items.add(PreferencesToggleItem("Utilizar Lanterna", R.drawable.ic_highlight_black_24dp, R.color.colorYellow))
        items.add(PreferencesToggleItem("Vibrar", R.drawable.ic_vibration_black_24dp, R.color.colorPurple))

        val preferencesAdapter = PreferencesToggleAdapter(context, items, activity)
        lvPreferencesToggle?.adapter = preferencesAdapter
    }
}