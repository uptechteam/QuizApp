package com.panhuk.quizapp

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(context: Context): Builder
    fun build(): ApplicationComponent
  }

  companion object {
    private lateinit var instance: ApplicationComponent


  }
}