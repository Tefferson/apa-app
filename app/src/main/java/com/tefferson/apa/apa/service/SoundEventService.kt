package com.tefferson.apa.apa.service

import android.content.Context
import com.android.volley.Response
import com.tefferson.apa.apa.model.request.LoginRequestModel
import org.json.JSONObject

class SoundEventService(val context: Context) {

    private val httpService by lazy { HttpService(context) }

    private val baseUrl = "registro-de-som/"

    fun list(listener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener) {

        val endpoint = baseUrl + "listar"

        httpService.get(
                endpoint,
                null,
                listener,
                errorListener
        )
    }
}