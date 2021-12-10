package com.panhuk.dataSourceimpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.panhuk.datasourceimpl.BuildConfig

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(BuildConfig.APP_PREFERENCES)