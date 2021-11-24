package com.example.api

import model.SessionToken
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizAPI {

    @GET("")
    fun getSessionToken(@Query("command") token: String = "request"): SessionToken

    @GET("")
    fun getQuestions(
        @Query("amount") amount: Int = 10,
        @Query("category") category: String,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String,
    ): String
}