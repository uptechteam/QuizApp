package com.panhuk.repository_impl

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.FirstTimeRepo
import kotlinx.coroutines.flow.Flow

class FirstTimeRepoImpl(private val datastorePreferences: DatastorePreferences) : FirstTimeRepo {
  override fun isFirstTimeAppOpened(): Flow<Boolean> {
    return datastorePreferences.isFirstTimeAppOpened()
  }
}