package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow

interface SessionTokenDataSource {

  val token: Flow<String?>
  suspend fun cacheToken(token: String)
}