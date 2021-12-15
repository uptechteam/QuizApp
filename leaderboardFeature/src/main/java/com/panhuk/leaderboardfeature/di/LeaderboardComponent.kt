package com.panhuk.leaderboardfeature.di

import com.panhuk.core.di.CoreComponent
import com.panhuk.leaderboardfeature.ui.LeaderboardFragment
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class
  ]
)
interface LeaderboardComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun build(): LeaderboardComponent
  }

  fun inject(leaderboardFragment: LeaderboardFragment)

  companion object {
    fun create(): LeaderboardComponent =
      DaggerLeaderboardComponent.builder()
        .coreComponent(CoreComponent.create())
        .build()
  }
}
