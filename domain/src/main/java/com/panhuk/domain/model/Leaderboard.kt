package com.panhuk.domain.model

import java.time.LocalDateTime

data class Leaderboard(
  val imageId: Int,
  val username: String,
  val score: Int,
  val scoreLocalDate: LocalDateTime
)