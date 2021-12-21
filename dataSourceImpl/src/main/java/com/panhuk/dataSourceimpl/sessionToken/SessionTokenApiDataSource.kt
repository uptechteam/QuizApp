package com.panhuk.dataSourceimpl.sessionToken

import com.panhuk.api.api.SessionTokenApi
import com.panhuk.datasource.SessionTokenDSReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SessionTokenApiDataSource(private val api: SessionTokenApi) : SessionTokenDSReader {
  override val token: Flow<String?>
    get() = flow { emit(api.getSessionToken().token) }  //TODO: handle error codes
}