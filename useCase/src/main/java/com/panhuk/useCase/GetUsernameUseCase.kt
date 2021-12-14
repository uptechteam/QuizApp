package com.panhuk.useCase

import kotlinx.coroutines.flow.Flow

interface GetUsernameUseCase {
  suspend fun saveUsername(username: String)
  fun getUsername(): Flow<String?>
}