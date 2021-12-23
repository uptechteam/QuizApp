package com.panhuk.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LeaderboardDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun leaderboardDao(): LeaderboardDao
}