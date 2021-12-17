package com.panhuk.quizapp

import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.datasourcedi.di.datastore.DatastoreComponent
import com.panhuk.datasourcedi.di.sessionToken.DaggerSessionTokenComponent
import com.panhuk.datasourcedi.di.sessionToken.SessionTokenComponent
import com.panhuk.datasourcedi.di.sessionToken.SessionTokenModule
import com.panhuk.repositorydi.firstTime.FirstTimeRepoComponent
import dagger.BindsInstance
import dagger.Component

@Component(
  dependencies = [
    FirstTimeRepoComponent::class,
    CoreComponent::class
  ]
)
interface MainComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun applicationContext(context: Context): Builder
    fun firstTimeRepoComponent(component: FirstTimeRepoComponent): Builder
    fun coreComponent(component: CoreComponent): Builder
    fun build(): MainComponent
  }

  companion object {
    fun create(context: Context): MainComponent =
      DaggerMainComponent.builder()
        .applicationContext(context)
        .firstTimeRepoComponent(FirstTimeRepoComponent.create(context))
        .coreComponent(CoreComponent.create())
        .build()
  }

}