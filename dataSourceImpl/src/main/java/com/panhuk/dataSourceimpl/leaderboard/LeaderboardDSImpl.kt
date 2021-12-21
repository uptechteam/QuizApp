package com.panhuk.dataSourceimpl.leaderboard

import com.panhuk.database.LeaderboardDao
import com.panhuk.datasource.LeaderboardDS
import com.panhuk.domain.model.Leaderboard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LeaderboardDSImpl(private val leaderboardDao: LeaderboardDao) : LeaderboardDS {
  override suspend fun insert(leaderboard: Leaderboard) {
    val databaseModel = leaderboard.mapToDB()
    leaderboardDao.insert(databaseModel)
  }

  override fun getLeaderboards(): Flow<List<Leaderboard>> {
    return leaderboardDao.getLeaderboards().map { value ->
      value.map { leaderboardDB ->
        leaderboardDB.mapToDomain()
      }
    }
  }
}