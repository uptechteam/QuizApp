package com.panhuk.leaderboardfeature.model

import com.panhuk.leaderboardfeature.R.drawable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = drawable.just_temp,
      username = "John",
      score = 20,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2021, 2), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Chris",
      score = 5,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2019, 2), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Anton",
      score = 2,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2020, 100), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Mother",
      score = 3,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Your father",
      score = 7,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = drawable.just_temp,
      username = "Dmitriy",
      score = 25,
      scoreLocalDate = LocalDateTime.now()
    )
  )
}