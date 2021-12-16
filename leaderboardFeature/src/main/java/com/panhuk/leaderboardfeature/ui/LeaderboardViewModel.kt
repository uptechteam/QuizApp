package com.panhuk.leaderboardfeature.ui

import com.panhuk.leaderboardfeature.R
import com.panhuk.leaderboardfeature.model.DataProvider
import com.panhuk.leaderboardfeature.model.Leaderboard
import javax.inject.Inject

class LeaderboardViewModel @Inject constructor() {
  val leaderboard: List<Leaderboard> = DataProvider.leaderboardList.sortedByDescending {
    it.scoreLocalDate
  }

  val sortTypes = listOf(R.string.sort_date, R.string.sort_score)

  fun sortByScore(): List<Leaderboard> {
    return leaderboard.sortedByDescending {
      it.score
    }
  }

  fun sortByTime(): List<Leaderboard> {
    return leaderboard.sortedByDescending {
      it.scoreLocalDate
    }
  }
}