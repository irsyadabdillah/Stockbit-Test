package com.stockbit.hiring.di

import com.stockbit.common.utils.Constant
import com.stockbit.hiring.BuildConfig
import com.stockbit.remote.ApiService
import com.stockbit.remote.RemoteDatasource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.sql.DataSource

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
val networkModule = module {

    single {
        OkHttpClient().newBuilder()
            .connectTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
//            .addInterceptor(RequestInterceptor(get()))
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            )
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        RemoteDatasource(get())
    }
}