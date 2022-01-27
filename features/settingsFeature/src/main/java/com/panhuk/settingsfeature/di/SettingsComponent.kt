package com.panhuk.settingsfeature.di

import android.content.Context
import com.panhuk.analyticdi.AnalyticComponent
import com.panhuk.core.di.CoreComponent
import com.panhuk.repositorydi.username.UsernameRepoComponent
import com.panhuk.settingsfeature.SettingsFragment
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class,
    UsernameRepoComponent::class,
    AnalyticComponent::class
  ]
)
interface SettingsComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun usernameRepoComponent(component: UsernameRepoComponent): Builder
    fun analyticComponent(component: AnalyticComponent): Builder
    fun build(): SettingsComponent
  }

  fun inject(settingsFragment: SettingsFragment)

  companion object {
    fun create(context: Context): SettingsComponent =
      DaggerSettingsComponent.builder()
        .coreComponent(CoreComponent.create())
        .usernameRepoComponent(UsernameRepoComponent.create(context))
        .analyticComponent(AnalyticComponent.create(context))
        .build()
  }
}