package com.panhuk.datasourceimpl

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenDSReader
import kotlinx.coroutines.flow.Flow

class SessionTokenLocalDataSource(private val datastorePreferences: DatastorePreferences) :
  SessionTokenDSReader, SessionTokenCache {

  override val token: Flow<String?>
    get() = datastorePreferences.getSessionToken()

  override suspend fun cacheToken(token: String?) {
    datastorePreferences.saveSessionToken(token!!)
  }
}