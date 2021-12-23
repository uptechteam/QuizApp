package com.panhuk.repository_impl

import com.panhuk.datasource.LeaderboardDS
import com.panhuk.domain.model.Leaderboard
import com.panhuk.repository.LeaderboardRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LeaderboardRepoImpl(private val leaderboardDS: LeaderboardDS) : LeaderboardRepo {
  override suspend fun insert(leaderboard: Leaderboard) {
    val databaseModel = leaderboard.mapToDB()
    leaderboardDS.insert(databaseModel)
  }

  override fun getLeaderboards(): Flow<List<Leaderboard>> {
    return leaderboardDS.getLeaderboards().map { value ->
      value.map { leaderboardDB ->
        leaderboardDB.mapToDomain()
      }
    }
  }
}