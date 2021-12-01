package com.example.leaderboardfeature.model

import java.util.Date

data class Leaderboard(
  val imageId: Int,
  val username: String,
  val score: Int,
  val date: Date
)