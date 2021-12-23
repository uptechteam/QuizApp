package com.panhuk.api.dto

import com.google.gson.annotations.SerializedName

data class CategoryTriviaResponse(
  @SerializedName("trivia_categories")
  val triviaResponse: List<CategoryResponse>
)