package com.panhuk.repositorydi.leaderboard

import com.panhuk.datasource.LeaderboardDS
import com.panhuk.repository.LeaderboardRepo
import com.panhuk.repository_impl.LeaderboardRepoImpl
import dagger.Module
import dagger.Provides

@Module
class LeaderboardRepoModule {
  @Provides
  fun provideLeaderboardRepo(
    leaderboardDS: LeaderboardDS
  ): LeaderboardRepo = LeaderboardRepoImpl(
    leaderboardDS
  )
}