package com.stockbit.hiring.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ActivityLoginBinding
import com.stockbit.hiring.ui.watchlist.WatchlistActivity

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(applicationContext, WatchlistActivity::class.java))
        }
    }


}