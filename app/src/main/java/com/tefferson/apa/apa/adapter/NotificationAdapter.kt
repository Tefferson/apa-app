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
import com.tefferson.apa.apa.model.NotificationItem
import com.tefferson.apa.apa.util.DateUtil

/**
 * Created by teffe on 27/08/2018.
 */
class NotificationAdapter(context: Context, items: List<NotificationItem>, private val activity: AppCompatActivity)
    : ArrayAdapter<NotificationItem>(context, R.layout.item_notification, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layout = LayoutInflater.from(context)
                .inflate(R.layout.item_notification, parent, false)

        initElements(layout, position)

        return layout
    }

    private fun initElements(layout: View?, position: Int) {

        val item = getItem(position)
        val tvEventRoom = layout?.findViewById<TextView>(R.id.tv_event_room)
        val tvEventType = layout?.findViewById<TextView>(R.id.tv_event_type)
        val tvEventDate = layout?.findViewById<TextView>(R.id.tv_event_date)
        val ivEventRoom = layout?.findViewById<ImageView>(R.id.iv_event_room)
        val ivEventType = layout?.findViewById<ImageView>(R.id.iv_event_type)

        tvEventRoom?.text = item.eventRoom
        tvEventType?.text = item.eventType
        tvEventDate?.text = DateUtil.GetFriendlyEventDate(item.eventDate)
        ivEventRoom?.setImageResource(item.roomResId)
        ivEventType?.setImageResource(item.typeResId)
    }
}