package com.panhuk.datasource

interface SessionTokenCache {

  suspend fun cacheToken(token: String?)
}