package com.panhuk.repository_impl

import com.panhuk.datasource.SessionTokenCache
import com.panhuk.domain.exception.SessionExpiredException
import com.panhuk.repository.SessionTokenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach

typealias RepositorySessionTokenReader = SessionTokenRepository
typealias DataSourceSessionTokenReader = com.panhuk.datasource.SessionTokenReader

class SessionTokenRepoImpl(
  private val sessionTokenApiReader: DataSourceSessionTokenReader,
  private val sessionTokenLocalReader: DataSourceSessionTokenReader,
  private val sessionTokenCache: SessionTokenCache
) : RepositorySessionTokenReader {

  override val currentSessionToken: Flow<String?>
    get() = sessionTokenLocalReader.token.onEach { cachedToken ->
      if(cachedToken.isNullOrBlank())
        throw SessionExpiredException()
    }

  override fun generateNewToken(): Flow<String?> =
    sessionTokenApiReader.token.flatMapLatest { token ->
      sessionTokenCache.cacheToken(token)
      sessionTokenLocalReader.token
    }
}