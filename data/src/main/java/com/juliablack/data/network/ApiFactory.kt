package com.juliablack.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createApi(): Api = Retrofit
    .Builder()
    .baseUrl("https://raw.githubusercontent.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()
    .create(Api::class.java)
