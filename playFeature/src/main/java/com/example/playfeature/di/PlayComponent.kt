package com.example.playfeature.di

import com.example.playfeature.PlayFragment
import com.panhuk.datasourcedi.di.SessionTokenComponent
import com.panhuk.repositorydi.QuestionRepoComponent
import com.panhuk.repositorydi.SessionTokenRepoComponent
import dagger.Component

@Component(dependencies = [SessionTokenComponent::class] )
interface PlayComponent {

  @Component.Builder
  interface Builder {
    fun sessionTokenComponent(component: SessionTokenComponent): Builder
    fun build(): PlayComponent
  }

  fun inject(playFragment: PlayFragment)

  companion object {
    fun create(playFragment: PlayFragment) =
      DaggerPlayComponent.builder()
        .sessionTokenComponent(SessionTokenComponent.create())
        .build()
        .inject(playFragment)
  }
}
