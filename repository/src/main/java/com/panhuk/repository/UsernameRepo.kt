package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface UsernameRepo {
  suspend fun saveUsername(username: String)
  fun getUsername(): Flow<String?>
}