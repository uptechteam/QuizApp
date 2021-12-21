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

  private lateinit var leaderboard: List<Leaderboard>
  var leaderboardSorted by mutableStateOf(sortByTime())
  val sortTypes = listOf(R.string.sort_date, R.string.sort_score)

  init {
    viewModelScope.launch(dispatcher) {
      leaderboardRepo.getLeaderboards().collect { leaderboard ->
        this@LeaderboardViewModel.leaderboard = leaderboard
      }
    }
  }

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

  fun setSortType(item: Int) {
    leaderboardSorted = if (item == R.string.sort_date) {
      sortByTime()
    } else {
      sortByScore()
    }
  }
}