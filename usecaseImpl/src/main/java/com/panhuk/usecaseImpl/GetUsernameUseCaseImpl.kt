package com.panhuk.usecaseImpl

import com.panhuk.datasource.DatastorePreferences
import com.panhuk.useCase.GetUsernameUseCase
import kotlinx.coroutines.flow.Flow

class GetUsernameUseCaseImpl(private val dataStorePreferences: DatastorePreferences) :
  GetUsernameUseCase {
  override suspend fun saveUsername(username: String) {
    dataStorePreferences.saveUsername(username)
  }

  override fun getUsername(): Flow<String?> {
    return dataStorePreferences.observeUsername()
  }
}