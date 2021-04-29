package com.idn.recipeapp.network

import com.google.firebase.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitConfig {
    val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS).build()
    val gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder().baseUrl(com.idn.recipeapp.BuildConfig.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(
        gson)).build()


}