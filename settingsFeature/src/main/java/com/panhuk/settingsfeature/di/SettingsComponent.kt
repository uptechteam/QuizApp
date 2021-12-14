package com.panhuk.settingsfeature.di

import com.panhuk.core.di.CoreComponent
import com.panhuk.settingsfeature.SettingsFragment
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class
  ]
)
interface SettingsComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun build(): SettingsComponent
  }

  fun inject(settingsFragment: SettingsFragment)

  companion object {
    fun create(): SettingsComponent =
      DaggerSettingsComponent.builder()
        .coreComponent(CoreComponent.create())
        .build()
  }
}