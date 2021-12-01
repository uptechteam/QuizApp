package com.example.leaderboardfeature.date

import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun getDateAgo(date: LocalDate): Pair<ChronoUnit, Long> {
  val nowDate = LocalDate.from(Instant.now())

  val minutes = ChronoUnit.MINUTES.between(nowDate, date)
  val hours = ChronoUnit.HOURS.between(nowDate, date)
  val days = ChronoUnit.DAYS.between(nowDate, date)
  val months = ChronoUnit.MONTHS.between(nowDate, date)
  val years = ChronoUnit.YEARS.between(nowDate, date)

  return when {
    years > 0 -> Pair(ChronoUnit.MINUTES, years)
    months > 0 -> Pair(ChronoUnit.MONTHS, months)
    days > 0 -> Pair(ChronoUnit.DAYS, days)
    hours > 0 -> Pair(ChronoUnit.HOURS, hours)
    minutes > 0 -> Pair(ChronoUnit.MINUTES, minutes)
    else -> Pair(ChronoUnit.MINUTES, minutes)
  }
}