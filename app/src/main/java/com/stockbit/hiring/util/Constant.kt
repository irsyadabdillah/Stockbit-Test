package com.stockbit.common.utils

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
object Constant {
    const val BASE_URL = "https://min-api.cryptocompare.com/"
    const val TSYM = "USD"
    const val PAGE = 0
    const val NETWORK_TIMEOUT = 60L
}

object ResponseCode {
    const val SUCCESS = 200
    const val GENERAL_ERROR = 500
    const val STORAGE_ALMOST_FULL = 8000
}