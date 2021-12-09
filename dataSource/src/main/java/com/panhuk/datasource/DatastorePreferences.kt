package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow

interface DatastorePreferences {
   suspend fun saveSessionToken(token: String?)
   fun observeSessionToken(): Flow<String?>
}