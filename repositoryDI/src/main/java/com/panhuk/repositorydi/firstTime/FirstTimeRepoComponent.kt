package com.panhuk.repositorydi.firstTime

import android.content.Context
import com.panhuk.datasourcedi.di.datastore.DatastoreComponent
import com.panhuk.repository.FirstTimeRepo
import dagger.Component

@Component(
  dependencies = [
    DatastoreComponent::class
  ],
  modules = [
    FirstTimeRepoModule::class
  ]
)
interface FirstTimeRepoComponent {

  fun getFirstTimeRepo(): FirstTimeRepo

  @Component.Builder
  interface Builder {
    fun datastoreComponent(component: DatastoreComponent): Builder
    fun firstTimeRepoModule(module: FirstTimeRepoModule): Builder
    fun build(): FirstTimeRepoComponent
  }

  companion object {
    fun create(applicationContext: Context): FirstTimeRepoComponent =
      DaggerFirstTimeRepoComponent.builder()
        .datastoreComponent(DatastoreComponent.create(applicationContext))
        .firstTimeRepoModule(FirstTimeRepoModule())
        .build()
  }
}