package com.panhuk.datasourcedi.di.datastore

import android.content.Context
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

  fun datastorePreferences(): DatastorePreferences

  @Component.Builder
  interface Builder {
    fun datastoreModule(module: DatastoreModule): Builder

    @BindsInstance
    fun context(context: Context): Builder
    fun build(): DatastoreComponent
  }

  companion object {
    // need to be always application context
    fun create(context: Context): DatastoreComponent =
      DaggerDatastoreComponent.builder()
        .datastoreModule(DatastoreModule())
        .context(context)
        .build()
  }
}