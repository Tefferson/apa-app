package com.tefferson.apa.apa.service

import android.content.Context
import android.net.Uri
import android.webkit.URLUtil
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import kotlin.reflect.full.memberProperties

class HttpService(val context: Context) {

    private val baseUrl = "http://apa-api.azurewebsites.net/api/"
    private val prefsFileName = "com.tefferson.apa.apa.httpservice.prefs"
    private val accessToken = "accesstoken"
    private val prefs by lazy { context.getSharedPreferences(prefsFileName, Context.MODE_PRIVATE) }

    fun post(
            endpoint: String,
            data: Any,
            listener: Response.Listener<JSONObject>,
            errorListener: Response.ErrorListener
    ) {
        val mutableMap = mutableMapOf<String, Any?>()

        for (prop in data.javaClass.kotlin.memberProperties)
            mutableMap[prop.name] = prop.get(data)

        val params = JSONObject(mutableMap)
        val url = baseUrl + endpoint

        val jsonObjectRequest = object : JsonObjectRequest(
                Request.Method.POST,
                url,
                params,
                listener,
                errorListener
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return buildHeaders()
            }
        }

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)
    }

    fun get(
            endpoint: String,
            data: MutableMap<String, Any>?,
            listener: Response.Listener<JSONObject>,
            errorListener: Response.ErrorListener
    ) {
        val ub = Uri.Builder()
        if (data != null)
            for (pair in data)
                ub.appendQueryParameter(pair.key, pair.value.toString())

        val url = baseUrl + endpoint + ub.build().toString()

        val jsonObjectRequest = object : JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                listener,
                errorListener
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return buildHeaders()
            }
        }

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)
    }

    fun buildHeaders(): MutableMap<String, String> {
        val accessToken = prefs.getString(this.accessToken, "")
        val headers = HashMap<String, String>()
        headers["Authorization"] = "Bearer $accessToken"
        return headers
    }

    fun setAccessToken(accessToken: String) {
        val editor = prefs.edit()
        editor.putString(this.accessToken, accessToken)
        editor.apply()
    }
}