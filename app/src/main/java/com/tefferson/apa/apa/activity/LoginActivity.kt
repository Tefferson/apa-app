package com.tefferson.apa.apa.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Response
import com.google.firebase.auth.FirebaseAuth
import com.tefferson.apa.apa.R
import com.tefferson.apa.apa.service.IdentityService

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val etEmail by lazy { findViewById<EditText>(R.id.et_email) }
    private val etPassword by lazy { findViewById<EditText>(R.id.et_password) }
    private val btSubmit by lazy { findViewById<Button>(R.id.bt_sign_in) }
    private val mAuth by lazy { FirebaseAuth.getInstance() }
    private val currentUser by lazy { mAuth.currentUser }
    private val identityService by lazy { IdentityService(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (currentUser != null) startMainActivity()

        initElements()
    }

    override fun onClick(viewItem: View?) {
        when (viewItem?.id) {
            R.id.bt_sign_in -> btSignInOnClick()
        }
    }

    private fun btSignInOnClick() {

        val login = etEmail.text.toString()
        val password = etPassword.text.toString()

        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                        getAccessTokenAndProceed(login, password)
                    else
                        Toast.makeText(this, "Falha ao autenticar", Toast.LENGTH_SHORT)
                                .show()
                }
    }

    private fun getAccessTokenAndProceed(login: String, password: String) {
        identityService.login(
                login,
                password,
                Response.Listener { response ->
                    startMainActivity()
                },
                Response.ErrorListener { }
        )
    }

    private fun initElements() {
        btSubmit.setOnClickListener(this)
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
