package com.example.retrofitanecdotecrud.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller {

    fun getApiArguments(): AnecdoteApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://umorili.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AnecdoteApi::class.java)
    }
}