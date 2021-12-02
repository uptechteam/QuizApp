package com.example.leaderboardfeature.model

import com.example.leaderboardfeature.R.drawable
import java.time.Instant
import java.time.LocalDateTime

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = drawable.just_temp,
      username = "John",
      score = 20,
      scoreLocalDate = LocalDateTime.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Chris",
      score = 5,
      scoreLocalDate = LocalDateTime.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Anton",
      score = 2,
      scoreLocalDate = LocalDateTime.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Your mother",
      score = 8,
      scoreLocalDate = LocalDateTime.from(Instant.now())
    )
  )
}