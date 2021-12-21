package com.panhuk.dataSourceimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
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

  override suspend fun saveUsername(username: String) {
    dataStore.edit { settings ->
      settings[USERNAME] = username
    }
  }

  override fun observeUsername(): Flow<String?> {
    return dataStore.data.map { preferences: Preferences ->
      preferences[USERNAME]
    }
  }

  override fun isFirstTimeAppOpened(): Flow<Boolean> {
    return dataStore.data.map { preferences: Preferences ->
      if (preferences[FIRST_TIME] == null) {
        setFirstTimeAppOpenedToFalse()
        true
      } else {
        false
      }
    }
  }

  private suspend fun setFirstTimeAppOpenedToFalse() {
    dataStore.edit { settings ->
      settings[FIRST_TIME] = false
    }
  }

  companion object {
    private const val TOKEN_CONFIG = "TOKEN"
    private val TOKEN = stringPreferencesKey(TOKEN_CONFIG)

    private const val USERNAME_CONFIG = "USERNAME"
    private val USERNAME = stringPreferencesKey(USERNAME_CONFIG)

    private const val FIRST_TIME_CONFIG = "FIRST_TIME"
    private val FIRST_TIME = booleanPreferencesKey(FIRST_TIME_CONFIG)
  }
}