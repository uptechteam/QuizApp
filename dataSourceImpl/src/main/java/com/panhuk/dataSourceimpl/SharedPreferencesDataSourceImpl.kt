package com.panhuk.dataSourceimplimport

import SharedPreferencesDataSource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class SharedPreferencesDataSourceImpl(private val dataStore: DataStore<Preferences>) :
  SharedPreferencesDataSource {

  // private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(BuildConfig.APP_PREFERENCES)
  private val TOKEN = stringPreferencesKey(BuildConfig.TOKEN)

  override var token: String?
    get() = dataStore.data.map { preferences: Preferences ->
      preferences[TOKEN]
    }.single()
    set(token) {
      dataStore.edit { settings ->
        settings[TOKEN] = token
      }
    }
}