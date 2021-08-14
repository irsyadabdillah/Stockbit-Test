package com.stockbit.hiring.ui.login

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ActivityLoginBinding
import com.stockbit.hiring.ui.watchlist.WatchlistActivity
import timber.log.Timber

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    var progressDialog: ProgressDialog? = null
    var _emailText: EditText? = null
    var _passwordText: EditText? = null
    var _loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        _emailText = binding.etEmail
        _passwordText = binding.etPassword
        _loginButton = binding.btnLogin

        actionBar()
        navigationToWatchlist()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_login_appbar, menu)
        return true
    }

    private fun actionBar() {
        setSupportActionBar(binding.toolbarLogin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setTitle("")
    }

    private fun navigationToWatchlist() {
        _loginButton!!.setOnClickListener {
            loginAcces()
        }
    }

    private fun loginAcces() {
        Timber.d("Login")

        if (!validate()) {
            onLoginFailed()
            return
        }

        _loginButton!!.isEnabled = false

        showProgress()

        android.os.Handler().postDelayed(
            {
                onLoginSuccess()
                hideProgress()
            }, 3000)

    }

    fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.show()
            if (progressDialog?.window != null) {
                progressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog?.setContentView(R.layout.layout_progress_dialog)
            progressDialog?.isIndeterminate = true
            progressDialog?.setCancelable(false)
            progressDialog?.setCanceledOnTouchOutside(false)
        } else {
            progressDialog?.show()
        }
    }

    fun hideProgress() {
        progressDialog?.dismiss()
    }

    fun onLoginSuccess() {
        _loginButton!!.isEnabled = true
//        finish()
        startActivity(Intent(this, WatchlistActivity::class.java))
    }

    fun onLoginFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        _loginButton!!.isEnabled = true
    }

    fun validate(): Boolean {
        var valid = true

        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText!!.error = "masukkan email yang benar"
            valid = false
        } else {
            _emailText!!.error = null
        }

        if (password.isEmpty() || password.length < 5 ) {
            _passwordText!!.error = "password tidak boleh kurang dari 5 digit "
            valid = false
        } else {
            _passwordText!!.error = null
        }

        return valid
    }




}