package com.panhuk.quizapp.di

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.quizapp.MainActivity
import com.panhuk.repositorydi.firstTime.FirstTimeRepoComponent
import dagger.BindsInstance
import dagger.Component

@Component(
  dependencies = [
    FirstTimeRepoComponent::class,
    CoreComponent::class
  ]
)
interface MainActivityComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(context: Context): Builder
    fun firstTimeRepoComponent(component: FirstTimeRepoComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun build(): MainActivityComponent
  }

  fun inject(mainActivity: MainActivity)

  companion object {
    fun create(context: Context): MainActivityComponent =
      DaggerMainActivityComponent.builder()
        .applicationContext(context)
        .firstTimeRepoComponent(FirstTimeRepoComponent.create(context))
        .coreComponent(CoreComponent.create())
        .build()
  }
}