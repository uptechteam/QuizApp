package com.panhuk.repository_impl

import com.panhuk.datasource.SessionTokenCache
import com.panhuk.datasource.SessionTokenDSReader
import com.panhuk.domain.exception.SessionExpiredException
import com.panhuk.repository.SessionTokenRepoReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class SessionTokenRepoImpl(
  private val sessionTokenApiReader: SessionTokenDSReader,
  private val sessionTokenLocalReader: SessionTokenDSReader,
  private val sessionTokenCache: SessionTokenCache
) : SessionTokenRepoReader {

  override val currentSessionToken: Flow<String?>
    get() = sessionTokenLocalReader.token.onEach { cachedToken ->
      if (cachedToken.isNullOrBlank())
        throw SessionExpiredException()
    }

  override fun generateNewToken(): Flow<String?> =
    sessionTokenApiReader.token.onEach { token ->
      sessionTokenCache.cacheToken(token)
      sessionTokenLocalReader.token
    }
}