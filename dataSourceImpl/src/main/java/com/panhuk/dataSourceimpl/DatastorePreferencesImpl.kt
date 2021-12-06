package com.panhuk.dataSourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasourceimpl.BuildConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastorePreferencesImpl(private val dataStore: DataStore<Preferences>) :
  DatastorePreferences {

  private val TOKEN = stringPreferencesKey(BuildConfig.TOKEN)

  override suspend fun saveSessionToken(token: String) {
    dataStore.edit { settings ->
      settings[TOKEN] = token
    }
  }

  override fun getSessionToken(): Flow<String?> {
    return dataStore.data.map { preferences: Preferences ->
      preferences[TOKEN]
    }
  }
}