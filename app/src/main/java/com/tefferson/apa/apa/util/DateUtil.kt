package com.tefferson.apa.apa.util

import java.util.*

/**
 * Created by teffe on 27/08/2018.
 */
object DateUtil {
    fun GetFriendlyEventDate(date: Date): String {
        val now = Date()
        val diff = now.time - date.time

        if (diff < 60 * 1000) {
            return "${diff / 1000}s"
        } else if (diff < 60 * 60 * 1000) {
            return "${diff / (60 * 1000)}m"
        } else if (diff < 24 * 3600 * 1000) {
            return "${diff / (3600 * 1000)}h"
        } else if (diff < 7 * 24 * 3600 * 1000) {
            return "${diff / (24 * 3600 * 1000)}d"
        } else {
            return date.toString()
        }
    }
}