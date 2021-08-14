package com.stockbit.hiring.ui.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stockbit.model.DataResponse
import com.stockbit.repository.Repository
import kotlinx.coroutines.launch

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
class WatchlistViewModel(val repository: Repository): ViewModel() {

    private val _watchlistResponse = MutableLiveData<List<DataResponse>>()
    val watchlistResponse: LiveData<List<DataResponse>> = _watchlistResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun requestWatchlist() = viewModelScope.launch {
        repository.getWatchlist().let {
            if (it.isSuccessful) {
                _watchlistResponse.postValue(listOf(it.body()!!))
            }else{
                _errorMessage.postValue(it.message())
            }
        }
    }
}