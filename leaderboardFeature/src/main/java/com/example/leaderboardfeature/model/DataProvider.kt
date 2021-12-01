package com.example.leaderboardfeature.model

import com.example.leaderboardfeature.R.drawable
import java.time.Instant
import java.time.LocalDate

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = drawable.just_temp,
      username = "John",
      score = 20,
      scoreLocalDate = LocalDate.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Chris",
      score = 5,
      scoreLocalDate = LocalDate.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Anton",
      score = 2,
      scoreLocalDate = LocalDate.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Your mother",
      score = 8,
      scoreLocalDate = LocalDate.from(Instant.now())
    )
  )
}