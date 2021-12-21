package com.panhuk.leaderboardfeature.utils

import com.panhuk.leaderboardfeature.R
import kotlin.random.Random

fun getDrawable(index: Int = Random.nextInt(11)): Int {
  val drawables = listOf(
    R.drawable.add1,
    R.drawable.add2,
    R.drawable.android1,
    R.drawable.android2,
    R.drawable.banana,
    R.drawable.cash,
    R.drawable.crown,
    R.drawable.favorite,
    R.drawable.goal,
    R.drawable.handicrafts
  )
  return drawables[index]
}