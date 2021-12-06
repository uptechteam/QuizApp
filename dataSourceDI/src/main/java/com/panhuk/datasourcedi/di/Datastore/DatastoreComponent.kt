package com.panhuk.datasourcedi.di.Datastore

import com.panhuk.datasource.DatastorePreferences
import dagger.BindsInstance
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

    @BindsInstance
    fun datastorePreferences(datastorePreferences: DatastorePreferences): Builder
    fun build(): DatastoreComponent
  }

  companion object {
    fun create(datastorePreferences: DatastorePreferences): DatastoreComponent =
      DatastoreComponent.builder()
        .datastoreModule(DatastoreModule())
        .datastorePreferences(datastorePreferences)
        .build()
  }
}