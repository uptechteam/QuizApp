package com.panhuk.dataSourceimpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasourceimpl.BuildConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatastorePreferencesImpl(private val context: Context) : DatastorePreferences {
  private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(BuildConfig.APP_PREFERENCES)
  private val TOKEN = stringPreferencesKey(BuildConfig.TOKEN)

  override suspend fun saveSessionToken(token: String) {
    context.dataStore.edit { settings ->
      settings[TOKEN] = token
    }
  }

  override fun getSessionToken(): Flow<String?> {
    return context.dataStore.data.map { preferences: Preferences ->
      preferences[TOKEN]
    }
  }
}