package com.nikunj.mockapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    val instance: NetworkService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(NetworkService::class.java)
    }
}
