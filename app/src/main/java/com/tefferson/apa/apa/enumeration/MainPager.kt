package com.tefferson.apa.apa.enumeration

import com.tefferson.apa.apa.R

/**
 * Created by teffe on 26/08/2018.
 */
enum class MainPager(val titleResId: Int, val layoutResId: Int, val itemId: Int, val colorResId: Int) {
    NOTIFICATIONS(R.string.notificacoes, R.layout.fragment_notifications, R.id.action_notifications, R.color.colorRed),
    MAIN(R.string.geral, R.layout.fragment_main, R.id.action_main, R.color.colorGreen),
    SETTINGS(R.string.configuracoes, R.layout.fragment_preferences, R.id.action_preferences, R.color.colorPurple)
}