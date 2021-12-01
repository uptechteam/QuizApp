package com.example.leaderboardfeature.date

import com.example.leaderboardfeature.date.DateType.DAYS
import com.example.leaderboardfeature.date.DateType.HOURS
import com.example.leaderboardfeature.date.DateType.MINUTES
import com.example.leaderboardfeature.date.DateType.MONTHS
import com.example.leaderboardfeature.date.DateType.YEARS
import java.time.Instant
import java.util.Date

fun getDateAgo(date: Date): Pair<DateType, Long> {
  val nowDate = Date.from(Instant.now())
  val differenceInTime = nowDate.time - date.time
  val seconds = differenceInTime / 1000
  val minutes = seconds / 60
  val hours = minutes / 60
  val days = hours / 24
  val months = days / 30
  val years = months / 12

  return when {
    minutes < 60 -> Pair(MINUTES, minutes)
    hours < 24 -> Pair(HOURS, hours)
    days < 30 -> Pair(DAYS, days)
    months < 12 -> Pair(MONTHS, months)
    else -> Pair(YEARS, years)
  }
}