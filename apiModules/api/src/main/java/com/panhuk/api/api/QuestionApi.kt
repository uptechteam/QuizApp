package com.panhuk.api.api

import com.panhuk.api.dto.BaseResponse
import com.panhuk.api.dto.CategoryTriviaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {
  @GET("api.php")
  suspend fun getQuestions(
    @Query("amount") amount: Int = 10,
    @Query("category") category: String? = null,
    @Query("difficulty") difficulty: String? = null,
    @Query("type") type: String? = null,
  ): BaseResponse

  @GET("api_category.php")
  suspend fun getCategories(): CategoryTriviaResponse
}