package com.example.setupquestionfeature.di

import com.example.setupquestionfeature.SetupQuestionsFragment
import dagger.Component

@Component()
interface SetupQuestionsComponent {

  @Component.Builder
  interface Builder {
    fun build(): SetupQuestionsComponent
  }

  fun inject(SetupQuestionsFragment: SetupQuestionsFragment)

  companion object {
    fun create(): SetupQuestionsComponent =
      DaggersetupQuestionsComponent.builder()
        .build()
  }
}
