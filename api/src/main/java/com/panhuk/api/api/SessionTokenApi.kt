package com.panhuk.api.api

import com.panhuk.api.dto.SessionTokenResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionTokenApi {
  @GET("api_token.php")
  fun getSessionToken(
    @Query("command") command: String = "request"
  ): Flow<SessionTokenResponse>
}