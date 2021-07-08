package com.nikunj.mockapp.service

import com.google.gson.GsonBuilder
import com.nikunj.mockapp.model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetworkService {

    @GET("471a59e3-25a5-49ab-b0c7-c7827b3cddcf")
    suspend fun getResults():Response<List<ClassesName>>


    @GET("471a59e3-25a5-49ab-b0c7-c7827b3cddcf")
   fun callgetResults() : Call<List<ClassesName>>
    companion object{
        operator fun invoke() : NetworkService {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://run.mocky.io/v3/")
                .build()
                .create(NetworkService::class.java)


        }
    }
}
