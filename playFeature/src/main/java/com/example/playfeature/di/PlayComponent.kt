package com.example.playfeature.di

import android.content.Context
import com.example.playfeature.PlayFragment
import com.example.usecasedi.UseCaseComponent
import com.panhuk.core.di.CoreComponent
import com.panhuk.repositorydi.SessionTokenRepoComponent
import dagger.Component

@Component(
  dependencies = [
    SessionTokenRepoComponent::class,
    UseCaseComponent::class,
    CoreComponent::class
  ]
)
interface PlayComponent {

  @Component.Builder
  interface Builder {
    fun sessionTokenRepoComponent(component: SessionTokenRepoComponent): Builder
    fun useCaseComponent(component: UseCaseComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun build(): PlayComponent
  }

  fun inject(playFragment: PlayFragment)

  companion object {
    fun create(context: Context): PlayComponent =
      DaggerPlayComponent.builder()
        .sessionTokenRepoComponent(SessionTokenRepoComponent.create(context))
        .useCaseComponent(UseCaseComponent.create())
        .coreComponent(CoreComponent.create())
        .build()
  }
}
