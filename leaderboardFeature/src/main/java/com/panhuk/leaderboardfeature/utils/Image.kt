package com.panhuk.leaderboardfeature

import kotlin.random.Random

fun getDrawable(): Int {
  return when (Random.nextInt(11)) {
    0 -> R.drawable.add1
    1 -> R.drawable.add2
    2 -> R.drawable.android1
    3 -> R.drawable.android2
    4 -> R.drawable.banana
    5 -> R.drawable.cash
    6 -> R.drawable.crown
    7 -> R.drawable.favorite
    8 -> R.drawable.footprint
    9 -> R.drawable.goal
    10 -> R.drawable.handicrafts
    else -> R.drawable.android2
  }
}