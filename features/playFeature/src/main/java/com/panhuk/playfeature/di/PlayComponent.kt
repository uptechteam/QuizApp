package com.panhuk.playfeature.di

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.playfeature.PlayFragment
import com.panhuk.repositorydi.SessionTokenRepoComponent
import com.panhuk.repositorydi.leaderboard.LeaderboardRepoComponent
import com.panhuk.repositorydi.username.UsernameRepoComponent
import com.panhuk.usecasedi.UseCaseComponent
import dagger.Component

@Component(
  dependencies = [
    SessionTokenRepoComponent::class,
    UseCaseComponent::class,
    LeaderboardRepoComponent::class,
    UsernameRepoComponent::class,
    CoreComponent::class
  ]
)
interface PlayComponent {

  @Component.Builder
  interface Builder {
    fun sessionTokenRepoComponent(component: SessionTokenRepoComponent): Builder
    fun useCaseComponent(component: UseCaseComponent): Builder
    fun leaderboardRepoComponent(component: LeaderboardRepoComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun usernameRepoComponent(component: UsernameRepoComponent): Builder
    fun build(): PlayComponent
  }

  fun inject(playFragment: PlayFragment)

  companion object {
    fun create(context: Context): PlayComponent =
      DaggerPlayComponent.builder()
        .sessionTokenRepoComponent(SessionTokenRepoComponent.create(context))
        .useCaseComponent(UseCaseComponent.create())
        .leaderboardRepoComponent(LeaderboardRepoComponent.create(context))
        .usernameRepoComponent(UsernameRepoComponent.create(context))
        .coreComponent(CoreComponent.create())
        .build()
  }
}
