package model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.panhuk.core.BuildConfig
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class PreferencesRepository(val context: Context) {

  private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(BuildConfig.APP_PREFERENCES)
  private val TOKEN = stringPreferencesKey(BuildConfig.TOKEN)

  suspend fun saveToken(token: String) {
    context.dataStore.edit { settings ->
      settings[TOKEN] = token
    }
  }

  suspend fun getToken(): String? {
    return context.dataStore.data.map { preferences: Preferences ->
      preferences[TOKEN]
    }.single()
  }
}