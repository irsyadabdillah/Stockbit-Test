package com.stockbit.hiring.ui.watchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.stockbit.hiring.R
import com.stockbit.hiring.adapter.WatchlistAdapter
import com.stockbit.hiring.databinding.ActivityWatchlistBinding
import com.stockbit.hiring.model.DataResponse
import org.koin.android.viewmodel.ext.android.viewModel

class WatchlistActivity : AppCompatActivity() {

    private val binding: ActivityWatchlistBinding by lazy {
        ActivityWatchlistBinding.inflate(layoutInflater)
    }

    private val watchlistAdapter: WatchlistAdapter by lazy {
        WatchlistAdapter()
    }

    private val viewModel: WatchlistViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        actionBar()
        observeWatchlist()
        setListAdapter()
        viewModel.requestWatchlist()
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

    private fun observeWatchlist() {
        viewModel.watchlistResponse.observe(this, {
            watchlistAdapter.setData(it)
        })
    }

    private fun setListAdapter() {
        binding.rvWatchlist.setHasFixedSize(true)
        binding.rvWatchlist.adapter = watchlistAdapter
    }
}