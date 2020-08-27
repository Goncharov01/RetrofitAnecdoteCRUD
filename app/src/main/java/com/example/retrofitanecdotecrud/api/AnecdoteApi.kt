package com.example.retrofitanecdotecrud.api

import com.example.retrofitanecdotecrud.entity.Anecdote
import retrofit2.http.GET
import retrofit2.http.Query
interface AnecdoteApi {

    @GET("/api/get")
    suspend fun getAnecdotes(
        @Query("name") name: String,
        @Query("num") num: Int
    ): List<Anecdote>
}