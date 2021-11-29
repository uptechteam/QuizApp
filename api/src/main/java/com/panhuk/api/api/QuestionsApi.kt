package com.panhuk.api.api

import com.panhuk.api.dto.BaseResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsApi {
  @GET("api_token.php")
  fun getQuestions(
    @Query("amount") amount: Int = 10,
    @Query("category") category: String,
    @Query("difficulty") difficulty: String,
    @Query("type") type: String,
  ): Flow<BaseResponse>
}