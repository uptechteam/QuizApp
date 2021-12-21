package com.panhuk.quizapp.di

import android.content.Context
import com.panhuk.quizapp.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
  modules = [MainActivityModule::class]
)
interface MainActivityComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(context: Context): Builder
    fun build(): MainActivityComponent
  }

  fun inject(mainActivity: MainActivity)

  companion object {
    fun create(context: Context): MainActivityComponent =
      DaggerMainActivityComponent.builder()
        .applicationContext(context)
        .build()
  }
}