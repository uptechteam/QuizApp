package com.panhuk.datasourcedi.di.Datastore

import android.content.Context
import com.panhuk.dataSourceimpl.DatastorePreferencesImpl
import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasourcedi.di.Api
import dagger.Module
import dagger.Provides

@Module
class DatastoreModule {

  @Provides
  fun provideDatastorePreferences(context: Context): DatastorePreferences =
    DatastorePreferencesImpl(context)
}