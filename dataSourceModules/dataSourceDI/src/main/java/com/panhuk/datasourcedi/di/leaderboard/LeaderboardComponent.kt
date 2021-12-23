package com.panhuk.datasourcedi.di.leaderboard

import android.content.Context
import com.panhuk.datasource.LeaderboardDS
import dagger.BindsInstance
import dagger.Component

@Component(
  modules = [
    LeaderboardModule::class
  ]
)
interface LeaderboardComponent {

  fun leaderboardDS(): LeaderboardDS

  @Component.Builder
  interface Builder {
    fun leaderboardModule(module: LeaderboardModule): Builder

    @BindsInstance
    fun context(context: Context): Builder
    fun build(): LeaderboardComponent
  }

  companion object {
    fun create(applicationContext: Context): LeaderboardComponent =
      DaggerLeaderboardComponent.builder()
        .leaderboardModule(LeaderboardModule())
        .context(applicationContext)
        .build()
  }
}