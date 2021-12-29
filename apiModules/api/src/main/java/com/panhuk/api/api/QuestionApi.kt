package com.panhuk.api.api

import com.panhuk.api.dto.BaseResponse
import com.panhuk.api.dto.CategoryTriviaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {
  @GET("api.php")
  suspend fun getQuestions(
    @Query("amount") amount: Int,
    @Query("category") category: String?,
    @Query("difficulty") difficulty: String?,
    @Query("type") type: String?,
    @Query("token") token: String?
  ): BaseResponse

  @GET("api_category.php")
  suspend fun getCategories(): CategoryTriviaResponse
}