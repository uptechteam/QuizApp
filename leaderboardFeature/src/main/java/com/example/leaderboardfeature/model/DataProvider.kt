package com.example.leaderboardfeature.model

import com.example.leaderboardfeature.R.drawable
import java.time.Instant
import java.util.Date

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = drawable.just_temp,
      username = "John",
      score = 20,
      date = Date.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Chris",
      score = 5,
      date = Date.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Anton",
      score = 2,
      date = Date.from(Instant.now())
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Your mother",
      score = 8,
      date = Date.from(Instant.now())
    )
  )
}