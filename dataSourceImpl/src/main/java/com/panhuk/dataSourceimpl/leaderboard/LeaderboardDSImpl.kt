package com.panhuk.dataSourceimpl.leaderboard

import com.panhuk.database.LeaderboardDB
import com.panhuk.database.LeaderboardDao
import com.panhuk.datasource.LeaderboardDS
import kotlinx.coroutines.flow.Flow

class LeaderboardDSImpl(private val leaderboardDao: LeaderboardDao) : LeaderboardDS {
  override suspend fun insert(leaderboardDB: LeaderboardDB) {
    leaderboardDao.insert(leaderboardDB)
  }

  override fun getLeaderboards(): Flow<List<LeaderboardDB>> {
    return leaderboardDao.getLeaderboards()
  }
}