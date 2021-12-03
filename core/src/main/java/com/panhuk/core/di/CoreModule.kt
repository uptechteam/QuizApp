package com.panhuk.core.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoreModule {
  @Provides
  fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}