package com.panhuk.datasource

import com.panhuk.domain.model.Leaderboard
import kotlinx.coroutines.flow.Flow

interface LeaderboardDS {
  suspend fun insert(leaderboard: Leaderboard)
  fun getLeaderboards(): Flow<List<Leaderboard>>
}