package com.tefferson.apa.apa.enumeration

import com.tefferson.apa.apa.R

enum class RoomIcon(val roomTag: String, val iconResId: Int) {

    LIVINGROOM("LIVINGROOM", R.mipmap.sofa) {
        override fun toString(): String = this.roomTag
    }
}