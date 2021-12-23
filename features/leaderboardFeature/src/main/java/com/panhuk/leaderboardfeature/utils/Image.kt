package com.panhuk.leaderboardfeature.utils

import com.panhuk.leaderboardfeature.R
import kotlin.random.Random

private val drawables = listOf(
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

fun getDrawableRes(): Int = drawables[Random.nextInt(drawables.size - 1)]