package com.panhuk.repositorydi.leaderboard

import android.content.Context
import com.panhuk.datasourcedi.di.leaderboard.LeaderboardComponent
import com.panhuk.repository.LeaderboardRepo
import dagger.Component

@Component(
  dependencies = [
    LeaderboardComponent::class
  ],
  modules = [
    LeaderboardRepoModule::class
  ]
)
interface LeaderboardRepoComponent {

  fun getLeaderboardRepo(): LeaderboardRepo

  @Component.Builder
  interface Builder {
    fun leaderboardComponent(component: LeaderboardComponent): Builder
    fun leaderboardRepoModule(module: LeaderboardRepoModule): Builder
    fun build(): LeaderboardRepoComponent
  }

  companion object {
    fun create(applicationContext: Context): LeaderboardRepoComponent =
      DaggerLeaderboardRepoComponent.builder()
        .leaderboardComponent(LeaderboardComponent.create(applicationContext))
        .leaderboardRepoModule(LeaderboardRepoModule())
        .build()
  }
}