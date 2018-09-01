package com.tefferson.apa.apa.service

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by teffe on 29/08/2018.
 */
class FirebaseIdService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d("tag-refresh-token", "Refreshed token: " + refreshedToken)
        super.onTokenRefresh()
    }
}