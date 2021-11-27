package com.panhuk.datasourceimpl

import com.panhuk.datasource.SessionTokenDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

object SessionTokenLocalDataSource : SessionTokenDataSource {
  private val _token: MutableSharedFlow<String?> = MutableSharedFlow()

  override val token: Flow<String?>
    get() = _token

  override suspend fun cacheToken(token: String) = _token.emit(token)
}