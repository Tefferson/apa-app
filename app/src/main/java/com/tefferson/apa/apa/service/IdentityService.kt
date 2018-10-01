package com.tefferson.apa.apa.service

import android.content.Context
import com.android.volley.Response
import com.tefferson.apa.apa.model.request.LoginRequestModel
import org.json.JSONObject

class IdentityService(val context: Context) {

    private val httpService by lazy { HttpService(context) }

    private val baseUrl = "identidade/"

    fun login(
            login: String,
            password: String,
            listener: Response.Listener<JSONObject>,
            errorListener: Response.ErrorListener
    ) {
        val endpoint = baseUrl + "autenticar"
        val credentials = LoginRequestModel(login, password)

        httpService.post(
                endpoint,
                credentials,
                Response.Listener { response ->
                    val data = response.getJSONObject("data")
                    val accessToken = data.getString("accessToken")
                    httpService.setAccessToken(accessToken)
                    listener.onResponse(response)
                },
                errorListener
        )
    }
}