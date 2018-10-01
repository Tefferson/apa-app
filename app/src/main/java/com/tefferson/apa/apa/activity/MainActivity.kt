package com.tefferson.apa.apa.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.android.volley.Response
import com.tefferson.apa.apa.R
import com.tefferson.apa.apa.adapter.MainPagerAdapter
import com.tefferson.apa.apa.enumeration.MainPager
import com.tefferson.apa.apa.service.DeviceService
import com.tefferson.apa.apa.util.BottomNavigationUtil

class MainActivity : AppCompatActivity(),
        ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private val vpMain by lazy { findViewById<ViewPager>(R.id.vp_main) }
    private val bottomNavigation by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation) }
    private val adapter by lazy { MainPagerAdapter(this, vpMain, this) }
    private val deviceService by lazy { DeviceService(this) }

    override fun onCreate(savedInstanceState: Bundle?) {

        //utilizar quando for em device físico
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deviceService.sendToken(Response.Listener { }, Response.ErrorListener { })

        initElements()
    }

    override fun onPageScrollStateChanged(state: Int) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {
        val itemId = MainPager.values()[position].itemId
        if (bottomNavigation.selectedItemId != itemId) {
            bottomNavigation.selectedItemId = itemId
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val idx = BottomNavigationUtil.getSelectedOrder(bottomNavigation, item)
        if (item.itemId != bottomNavigation.selectedItemId && vpMain.currentItem != idx) {
            vpMain.currentItem = idx
        }
        return true
    }

    private fun initElements() {
        vpMain.adapter = adapter
        vpMain.offscreenPageLimit = Int.MAX_VALUE
        vpMain.addOnPageChangeListener(this)

        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }
}
