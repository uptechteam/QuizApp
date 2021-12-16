package com.panhuk.leaderboardfeature.utils

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun getDateAgo(date: LocalDateTime): Pair<ChronoUnit, Long> {
  val nowDate = LocalDateTime.now()

  val minutes = calculateBetween(ChronoUnit.MINUTES, date, nowDate)
  val hours = calculateBetween(ChronoUnit.HOURS, date, nowDate)
  val days = calculateBetween(ChronoUnit.DAYS, date, nowDate)
  val months = calculateBetween(ChronoUnit.MONTHS, date, nowDate)
  val years = calculateBetween(ChronoUnit.YEARS, date, nowDate)

  return when {
    years > 0 -> Pair(ChronoUnit.YEARS, years)
    months > 0 -> Pair(ChronoUnit.MONTHS, months)
    days > 0 -> Pair(ChronoUnit.DAYS, days)
    hours > 0 -> Pair(ChronoUnit.HOURS, hours)
    minutes > 0 -> Pair(ChronoUnit.MINUTES, minutes)
    else -> Pair(ChronoUnit.MINUTES, minutes)
  }
}

private fun calculateBetween(
  chronoUnit: ChronoUnit,
  date: LocalDateTime,
  nowDate: LocalDateTime
): Long {
  return chronoUnit.between(date, nowDate)
}