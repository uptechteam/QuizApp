package com.panhuk.leaderboardfeature.model

import com.panhuk.leaderboardfeature.getDrawable
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object DataProvider {
  val leaderboardList = listOf(
    Leaderboard(
      imageId = getDrawable(),
      username = "John",
      score = 20,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2021, 2), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = getDrawable(),
      username = "Chris",
      score = 5,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2019, 2), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = getDrawable(),
      username = "Anton",
      score = 2,
      scoreLocalDate = LocalDateTime.of(LocalDate.ofYearDay(2020, 100), LocalTime.NOON)
    ),
    Leaderboard(
      imageId = getDrawable(),
      username = "Mother",
      score = 3,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = getDrawable(),
      username = "Your father",
      score = 7,
      scoreLocalDate = LocalDateTime.now()
    ),
    Leaderboard(
      imageId = getDrawable(),
      username = "Dmitriy",
      score = 25,
      scoreLocalDate = LocalDateTime.now()
    )
  )
}