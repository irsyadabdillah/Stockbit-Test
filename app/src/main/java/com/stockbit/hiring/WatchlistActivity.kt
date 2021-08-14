package com.stockbit.hiring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.stockbit.hiring.databinding.ActivityLoginBinding
import com.stockbit.hiring.databinding.ActivityWatchlistBinding

class WatchlistActivity : AppCompatActivity() {

    private val binding: ActivityWatchlistBinding by lazy {
        ActivityWatchlistBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_watclist, menu)
        return true
    }

    private fun actionBar() {
        setSupportActionBar(binding.toolbarLogin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setTitle("")
    }
}