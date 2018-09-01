package com.tefferson.apa.apa.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by teffe on 29/08/2018.
 */
class ForegroundMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d("tag-message-received", "From: " + remoteMessage?.from)

        if (remoteMessage?.data?.size!! > 0) {
            Log.d("tag-message-payload", "<essage data payload: " + remoteMessage?.data)

            if (true) {
                //firebase job dispatcher - if long tasks
                //schedulejob
            } else {
                // até 10 segundos
                //handlenow
            }
        }

        if (remoteMessage?.notification != null) {
            Log.d("tag-message-payload", "Message Notification Body: " + remoteMessage?.notification?.body)
        }
    }
}