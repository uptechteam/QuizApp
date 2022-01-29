package com.panhuk.leaderboardfeature.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panhuk.domain.model.Leaderboard
import com.panhuk.leaderboardfeature.R
import com.panhuk.repository.LeaderboardRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeaderboardViewModel @Inject constructor(
  private val leaderboardRepo: LeaderboardRepo,
  private val dispatcher: CoroutineDispatcher
) : ViewModel() {

  private lateinit var leaderboards: List<Leaderboard>
  var leaderboardSorted by mutableStateOf(listOf<Leaderboard>())
  val sortTypes = listOf(R.string.sort_date, R.string.sort_score)
  var isLeaderboardEmpty by mutableStateOf(false)

  init {
    viewModelScope.launch(dispatcher) {
      leaderboardRepo.getLeaderboards().collect { leaderboard ->
        leaderboards = leaderboard
        if (leaderboards.isEmpty()) {
          isLeaderboardEmpty = true
        } else {
          leaderboardSorted = sortByTime()
        }
      }
    }
  }

  private fun sortByScore(): List<Leaderboard> {
    return leaderboards.sortedByDescending {
      it.score
    }
  }

  private fun sortByTime(): List<Leaderboard> {
    return leaderboards.sortedByDescending {
      it.scoreLocalDate
    }
  }

  fun setSortType(item: Int) {
    leaderboardSorted = if (item == R.string.sort_date && leaderboards.isNotEmpty()) {
      sortByTime()
    } else {
      sortByScore()
    }
  }
}