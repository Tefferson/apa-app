package com.tefferson.apa.apa.enumeration

import com.tefferson.apa.apa.R

/**
 * Created by teffe on 27/08/2018.
 */
enum class DeafnessDegree(val label: String, val iconResId: Int, val deafnessLevel: Int) {
    LIGHT("Leve", R.drawable.ic_signal_cellular_1_bar_black_24dp, 1) {
        override fun toString(): String = this.label
    },
    MODERATE("Moderado", R.drawable.ic_signal_cellular_2_bar_black_24dp, 2) {
        override fun toString(): String = this.label
    },
    SEVERE("Severo", R.drawable.ic_signal_cellular_3_bar_black_24dp, 3) {
        override fun toString(): String = this.label
    },
    PROFOUND("Profundo", R.drawable.ic_signal_cellular_4_bar_black_24dp, 4) {
        override fun toString(): String = this.label
    }
}