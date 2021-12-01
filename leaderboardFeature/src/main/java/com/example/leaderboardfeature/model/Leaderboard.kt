package com.example.leaderboardfeature.model

import java.time.LocalDate

data class Leaderboard(
  val imageId: Int,
  val username: String,
  val score: Int,
  val scoreLocalDate: LocalDate
)