package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface FirstTimeRepo {
  fun isFirstTime(): Flow<Boolean>
}