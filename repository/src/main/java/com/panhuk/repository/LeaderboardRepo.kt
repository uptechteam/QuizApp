package com.panhuk.repository

import com.panhuk.domain.model.Leaderboard
import kotlinx.coroutines.flow.Flow

interface LeaderboardRepo {
  suspend fun insert(leaderboard: Leaderboard)
  fun getLeaderboards(): Flow<List<Leaderboard>>
}