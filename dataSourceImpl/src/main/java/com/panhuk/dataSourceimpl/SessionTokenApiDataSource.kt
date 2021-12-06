package com.panhuk.datasourceimpl

import com.panhuk.api.api.SessionTokenApi
import com.panhuk.datasource.SessionTokenReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SessionTokenApiDataSource(private val api: SessionTokenApi) : SessionTokenReader {
  override val token: Flow<String?>
    get() = flow { api.getSessionToken().token }  //TODO: handle error codes
}