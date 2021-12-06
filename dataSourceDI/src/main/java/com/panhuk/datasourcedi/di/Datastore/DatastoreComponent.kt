package com.panhuk.datasourcedi.di.Datastore

import com.panhuk.datasource.DatastorePreferences
import dagger.Component

@Component(
  modules = [
    DatastoreModule::class
  ]
)
interface DatastoreComponent {

  fun getDatastorePreferences(): DatastorePreferences

  @Component.Builder
  interface Builder {
    fun datastoreModule(module: DatastoreModule): Builder
    fun build(): DatastoreComponent
  }

  companion object {
    fun create(): DatastoreComponent =
      DatastoreComponent.builder()
        .datastoreModule(DatastoreModule())
        .build()
  }
}