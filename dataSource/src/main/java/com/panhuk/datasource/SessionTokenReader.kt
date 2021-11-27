package com.panhuk.datasource

import kotlinx.coroutines.flow.Flow

interface SessionTokenReader {

  val token: Flow<String?>
}