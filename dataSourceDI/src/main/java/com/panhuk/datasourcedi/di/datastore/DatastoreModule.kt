package com.panhuk.datasourcedi.di.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.panhuk.dataSourceimpl.DatastorePreferencesImpl
import com.panhuk.datasource.DatastorePreferences
import dagger.Module
import dagger.Provides

@Module
class DatastoreModule {

  @Provides
  fun provideDatastorePreferences(datastorePreferences: DataStore<Preferences>): DatastorePreferences =
    DatastorePreferencesImpl(datastorePreferences)
}