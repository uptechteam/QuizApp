package com.example.apidi.sessionTokenApi

import com.panhuk.api.api.SessionTokenApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SessionTokenApiModule {
  @Provides
  fun provideSessionTokenApi(retrofit: Retrofit): SessionTokenApi =
    retrofit.create(SessionTokenApi::class.java)
}