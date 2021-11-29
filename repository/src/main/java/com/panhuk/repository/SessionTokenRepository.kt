package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface SessionTokenRepository {
  val currentSessionToken: Flow<String?>
  fun generateNewToken(): Flow<String?>
}