package com.panhuk.api.dto

import com.google.gson.annotations.SerializedName

data class SessionTokenResponse(
  @SerializedName("response_code")
  val responseCode: Int,
  @SerializedName("response_code")
  val responseMessage: String,
  val token: String
)