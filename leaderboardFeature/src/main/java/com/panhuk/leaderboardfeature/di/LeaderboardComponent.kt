package com.panhuk.leaderboardfeature.di

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.leaderboardfeature.ui.LeaderboardFragment
import com.panhuk.repositorydi.leaderboard.LeaderboardRepoComponent
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class,
    LeaderboardRepoComponent::class
  ]
)
interface LeaderboardComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun leaderboardComponent(component: LeaderboardRepoComponent): Builder
    fun build(): LeaderboardComponent
  }

  fun inject(leaderboardFragment: LeaderboardFragment)

  companion object {
    fun create(applicationContext: Context): LeaderboardComponent =
      DaggerLeaderboardComponent.builder()
        .coreComponent(CoreComponent.create())
        .leaderboardComponent(LeaderboardRepoComponent.create(applicationContext))
        .build()
  }
}
