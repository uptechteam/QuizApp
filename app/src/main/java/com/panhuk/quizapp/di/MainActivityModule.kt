package com.panhuk.quizapp.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

  @Provides
  fun provideFirebaseAnalytic(context: Context) = FirebaseAnalytics.getInstance(context)
}