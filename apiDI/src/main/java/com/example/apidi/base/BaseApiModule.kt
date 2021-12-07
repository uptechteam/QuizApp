package com.example.apidi.base

import com.panhuk.api.BuildConfig
import dagger.Module
import dagger.Provides
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
      .build()
}