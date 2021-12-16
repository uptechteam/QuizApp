package com.panhuk.leaderboardfeature.utils

import com.panhuk.leaderboardfeature.R.drawable
import kotlin.random.Random

fun getDrawable(): Int {
  return when (Random.nextInt(11)) {
    0 -> drawable.add1
    1 -> drawable.add2
    2 -> drawable.android1
    3 -> drawable.android2
    4 -> drawable.banana
    5 -> drawable.cash
    6 -> drawable.crown
    7 -> drawable.favorite
    8 -> drawable.footprint
    9 -> drawable.goal
    10 -> drawable.handicrafts
    else -> drawable.android2
  }
}