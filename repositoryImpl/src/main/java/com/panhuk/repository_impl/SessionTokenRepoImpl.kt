package com.panhuk.repository_impl

import com.panhuk.datasource.SessionTokenDataSource
import com.panhuk.repository.SessionTokenReader
import kotlinx.coroutines.flow.Flow

class SessionTokenRepoImpl(
  private val sessionTokenDataSource: SessionTokenDataSource
) : SessionTokenReader {

  override val token: Flow<String?>
    get() = sessionTokenDataSource.token
}