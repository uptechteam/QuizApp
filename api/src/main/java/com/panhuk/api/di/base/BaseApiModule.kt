package com.panhuk.api.di.base

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.panhuk.api.BuildConfig
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class BaseApiModule {
  @Provides
  fun provideOkhttpClient(): OkHttpClient =
    OkHttpClient.Builder()
      .build()

  @Provides
  fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

  @Provides
  fun provideRetrofit(
    okHttpClient: OkHttpClient,
    converterFactory: Converter.Factory
  ): Retrofit =
    Retrofit.Builder()
      .baseUrl(BuildConfig.TRIVIA_BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(converterFactory)
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
}