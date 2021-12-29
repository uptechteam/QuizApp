package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow

interface SessionTokenDSReader {
  val token: Flow<String?>
}