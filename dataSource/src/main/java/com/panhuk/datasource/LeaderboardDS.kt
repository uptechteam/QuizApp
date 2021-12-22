package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow
import com.panhuk.database.LeaderboardDB

interface LeaderboardDS {
  suspend fun insert(leaderboardDB: LeaderboardDB)
  fun getLeaderboards(): Flow<List<LeaderboardDB>>
}