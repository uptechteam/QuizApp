package com.panhuk.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeaderboardDao {
  @Query("SELECT * FROM leaderboarddb")
  fun getLeaderboards(): Flow<List<LeaderboardDB>>

  @Insert
  fun insert(leaderboardDB: LeaderboardDB)
}