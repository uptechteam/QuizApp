package com.panhuk.quizapp

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.repositorydi.firstTime.FirstTimeRepoComponent
import dagger.BindsInstance
import dagger.Component

@Component(
  dependencies = [
    FirstTimeRepoComponent::class,
    CoreComponent::class
  ]
)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(context: Context): Builder
    fun firstTimeRepoComponent(component: FirstTimeRepoComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun build(): ApplicationComponent
  }

  companion object {
    private lateinit var instance: ApplicationComponent
  }
}