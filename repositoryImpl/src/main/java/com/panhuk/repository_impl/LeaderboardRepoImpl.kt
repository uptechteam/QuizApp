package com.panhuk.repository_impl

import com.panhuk.datasource.LeaderboardDS
import com.panhuk.domain.model.Leaderboard
import com.panhuk.repository.LeaderboardRepo
import kotlinx.coroutines.flow.Flow

class LeaderboardRepoImpl(private val leaderboardDS: LeaderboardDS) : LeaderboardRepo {
  override suspend fun insert(leaderboard: Leaderboard) {
    leaderboardDS.insert(leaderboard)
  }

  override fun getLeaderboards(): Flow<List<Leaderboard>> {
    return leaderboardDS.getLeaderboards()
  }
}