package com.panhuk.repository

import kotlinx.coroutines.flow.Flow

interface SessionTokenReader {

  val token: Flow<String?>
}