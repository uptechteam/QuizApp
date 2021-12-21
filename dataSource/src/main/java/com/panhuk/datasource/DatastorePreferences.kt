package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow

interface DatastorePreferences {
  suspend fun saveSessionToken(token: String?)
  fun observeSessionToken(): Flow<String?>
  suspend fun saveUsername(username: String)
  fun observeUsername(): Flow<String?>
  fun isFirstTimeAppOpened(): Flow<Boolean>
}