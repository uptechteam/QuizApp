package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface SessionTokenReader {
  val currentSessionToken: Flow<String?>
  fun generateNewToken(): Flow<String?>
}