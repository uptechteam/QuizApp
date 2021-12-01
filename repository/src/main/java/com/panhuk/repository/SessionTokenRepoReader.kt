package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface SessionTokenRepoReader {
  val currentSessionToken: Flow<String?>
  fun generateNewToken(): Flow<String?>
}