package com.panhuk.repository_impl.firstTime

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.repository.FirstTimeRepo
import kotlinx.coroutines.flow.Flow

class FirstTimeRepoImpl(private val datastorePreferences: DatastorePreferences) : FirstTimeRepo {
  override fun isFirstTimeAppOpened(): Flow<Boolean> {
    return datastorePreferences.isFirstTimeAppOpened()
  }

  override suspend fun setFirstTimeAppOpenedToFalse() {
    datastorePreferences.setFirstTimeAppOpenedToFalse()
  }
}