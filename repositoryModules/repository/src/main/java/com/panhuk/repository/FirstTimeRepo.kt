package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface FirstTimeRepo {
  fun isFirstTimeAppOpened(): Flow<Boolean>
  suspend fun setFirstTimeAppOpenedToFalse()
}