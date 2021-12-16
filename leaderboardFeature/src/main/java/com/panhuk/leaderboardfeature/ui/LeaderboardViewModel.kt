package com.panhuk.leaderboardfeature.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.panhuk.leaderboardfeature.R
import com.panhuk.leaderboardfeature.model.DataProvider
import com.panhuk.leaderboardfeature.model.Leaderboard
import javax.inject.Inject

class LeaderboardViewModel @Inject constructor() {
  private val leaderboard: List<Leaderboard> = DataProvider.leaderboardList
  var leaderboardSorted by mutableStateOf(sortByTime())

  val sortTypes = listOf(R.string.sort_date, R.string.sort_score)

  private fun sortByScore(): List<Leaderboard> {
    return leaderboard.sortedByDescending {
      it.score
    }
  }

  private fun sortByTime(): List<Leaderboard> {
    return leaderboard.sortedByDescending {
      it.scoreLocalDate
    }
  }

  fun sort(item: Int) {
    leaderboardSorted = when (item) {
      sortTypes[0] -> sortByTime()
      sortTypes[1] -> sortByScore()
      else -> sortByTime()
    }
  }
}