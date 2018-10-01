package com.tefferson.apa.apa.service

import android.content.Context
import com.android.volley.Response
import com.google.firebase.iid.FirebaseInstanceId
import com.tefferson.apa.apa.model.request.SendTokenRequestModel
import org.json.JSONObject

class DeviceService(val context: Context) {

    private val httpService by lazy { HttpService(context) }

    private val baseUrl = "dispositivo/"

    fun sendToken(
            listener: Response.Listener<JSONObject>,
            errorListener: Response.ErrorListener
    ) {
        val endpoint = baseUrl + "enviar-token"
        val token = FirebaseInstanceId.getInstance().token

        val tokenRequestModel = SendTokenRequestModel(token!!)

        httpService.post(
                endpoint,
                tokenRequestModel,
                listener,
                errorListener
        )
    }
}