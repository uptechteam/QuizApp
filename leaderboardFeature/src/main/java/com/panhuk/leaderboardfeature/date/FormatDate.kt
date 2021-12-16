package com.panhuk.leaderboardfeature.date

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun getDateAgo(date: LocalDateTime): Pair<ChronoUnit, Long> {
  val nowDate = LocalDateTime.now()

  val minutes = ChronoUnit.MINUTES.between(date, nowDate)
  val hours = ChronoUnit.HOURS.between(date, nowDate)
  val days = ChronoUnit.DAYS.between(date, nowDate)
  val months = ChronoUnit.MONTHS.between(date, nowDate)
  val years = ChronoUnit.YEARS.between(date, nowDate)

  return when {
    years > 0 -> Pair(ChronoUnit.YEARS, years)
    months > 0 -> Pair(ChronoUnit.MONTHS, months)
    days > 0 -> Pair(ChronoUnit.DAYS, days)
    hours > 0 -> Pair(ChronoUnit.HOURS, hours)
    minutes > 0 -> Pair(ChronoUnit.MINUTES, minutes)
    else -> Pair(ChronoUnit.MINUTES, minutes)
  }
}