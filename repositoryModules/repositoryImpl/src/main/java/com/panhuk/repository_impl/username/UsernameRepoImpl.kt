package com.panhuk.repository_impl.username

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.UsernameRepo
import kotlinx.coroutines.flow.Flow

class UsernameRepoImpl(private val datastorePreferences: DatastorePreferences) : UsernameRepo {
  override suspend fun saveUsername(username: String) {
    datastorePreferences.saveUsername(username)
  }

  override fun getUsername(): Flow<String?> {
    return datastorePreferences.observeUsername()
  }
}