package com.panhuk.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeaderboardDao {
  @Query("SELECT * FROM leaderboarddb")
  fun getLeaderboards(): Flow<List<LeaderboardDB>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(leaderboardDB: LeaderboardDB)
}