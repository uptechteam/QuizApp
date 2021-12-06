package com.panhuk.datasourcedi.di.Datastore

import androidx.datastore.core.DataStore
import com.panhuk.datasource.DatastorePreferences
import dagger.BindsInstance
import dagger.Component
import java.util.prefs.Preferences

@Component(
  modules = [
    DatastoreModule::class
  ]
)
interface DatastoreComponent {

  @Component.Builder
  interface Builder {
    fun datastoreModule(module: DatastoreModule): Builder

    @BindsInstance
    fun datastorePreferences(datastorePreferences: DataStore<Preferences>): Builder
    fun build(): DatastoreComponent
  }

  companion object {
    fun create(datastorePreferences: DataStore<Preferences>): DatastoreComponent =
      DatastoreComponent.builder()
        .datastoreModule(DatastoreModule())
        .datastorePreferences(datastorePreferences)
        .build()
  }
}