package com.panhuk.leaderboardfeature.model

import com.panhuk.leaderboardfeature.R.drawable
import java.time.Instant
import java.time.LocalDateTime

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = drawable.just_temp,
      username = "John",
      score = 20,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Chris",
      score = 5,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Anton",
      score = 2,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Your mother",
      score = 8,
      scoreLocalDate = LocalDateTime.now()
    )
  )
}