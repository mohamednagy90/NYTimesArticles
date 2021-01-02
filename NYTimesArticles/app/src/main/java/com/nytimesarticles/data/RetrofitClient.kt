package com.nytimesarticles.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit Client Singleton class
 */
class RetrofitClient private constructor() {

    companion object {
        val instance: Retrofit by lazy { RetrofitClient().retrofit } // lazy-init the client
    }

    // actual client instance
    private val retrofit: Retrofit

    init {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(Urls.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}