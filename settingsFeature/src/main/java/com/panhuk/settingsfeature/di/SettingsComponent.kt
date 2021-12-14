package com.panhuk.settingsfeature.di

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.settingsfeature.SettingsFragment
import com.panhuk.usecasedi.UseCaseComponent
import dagger.Component

@Component(
  dependencies = [
    CoreComponent::class,
    UseCaseComponent::class
  ]
)
interface SettingsComponent {

  @Component.Builder
  interface Builder {
    fun coreComponent(component: CoreComponent): Builder
    fun useCaseComponent(component: UseCaseComponent): Builder
    fun build(): SettingsComponent
  }

  fun inject(settingsFragment: SettingsFragment)

  companion object {
    fun create(context: Context): SettingsComponent =
      DaggerSettingsComponent.builder()
        .coreComponent(CoreComponent.create())
        .useCaseComponent(UseCaseComponent.create(context))
        .build()
  }
}