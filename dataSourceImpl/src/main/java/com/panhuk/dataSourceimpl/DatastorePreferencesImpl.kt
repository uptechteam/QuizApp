package com.panhuk.dataSourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.panhuk.datasource.DatastorePreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastorePreferencesImpl(private val dataStore: DataStore<Preferences>) :
  DatastorePreferences {

  override suspend fun saveSessionToken(token: String?) {
    if (token == null) return

    dataStore.edit { settings ->
      settings[TOKEN] = token
    }
  }

  override fun observeSessionToken(): Flow<String?> {
    return dataStore.data.map { preferences: Preferences ->
      preferences[TOKEN]
    }
  }

  companion object {
    private const val TOKEN_CONFIG = "TOKEN"
    private val TOKEN = stringPreferencesKey(TOKEN_CONFIG)
  }
}