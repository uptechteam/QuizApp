package com.panhuk.api.dto

import com.google.gson.annotations.SerializedName

data class BaseResponse(
  @SerializedName("response_code")
  val responseCode: Int,
  val results: List<QuestionResponse>
)