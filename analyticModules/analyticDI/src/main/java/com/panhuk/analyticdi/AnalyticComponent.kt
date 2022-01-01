package com.panhuk.analyticdi

import android.content.Context
import com.panhuk.analytic.Analytic
import dagger.BindsInstance
import dagger.Component

@Component(
  modules = [
    AnalyticModule::class
  ]
)
interface AnalyticComponent {

  fun getAnalytic(): Analytic

  @Component.Builder
  interface Builder {
    fun analyticsModule(module: AnalyticModule): Builder
    @BindsInstance fun context(context: Context): Builder
    fun build(): AnalyticComponent
  }

  companion object {
    fun create(context: Context): AnalyticComponent =
      DaggerAnalyticComponent.builder()
        .analyticsModule(AnalyticModule())
        .context(context)
        .build()
  }
}