package com.panhuk.datasourcedi.di.leaderboard

import android.content.Context
import androidx.room.Room
import com.panhuk.dataSourceimpl.leaderboard.LeaderboardDSImpl
import com.panhuk.database.AppDatabase
import com.panhuk.database.LeaderboardDao
import com.panhuk.datasource.LeaderboardDS
import dagger.Module
import dagger.Provides

@Module
class LeaderboardModule {
  @Provides
  fun provideDatabase(applicationContext: Context): AppDatabase {
    return Room.databaseBuilder(
      applicationContext,
      AppDatabase::class.java, "DB"
    ).build()
  }

  @Provides
  fun provideLeaderboardDao(appDatabase: AppDatabase): LeaderboardDao {
    return appDatabase.leaderboardDao()
  }

  @Provides
  fun provideLeaderboardDS(leaderboardDao: LeaderboardDao): LeaderboardDS =
    LeaderboardDSImpl(leaderboardDao)
}