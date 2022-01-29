package com.panhuk.api.api

import com.panhuk.api.dto.QuestionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {
  @GET("questions")
  suspend fun getQuestions(
    @Query("limit") limit: Int,
    @Query("categories") category: String? = null
  ): List<QuestionResponse>
}