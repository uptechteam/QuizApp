package com.panhuk.analyticdi

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.panhuk.analytic.Analytic
import com.panhuk.analyticimpl.AnalyticImpl
import dagger.Module
import dagger.Provides

@Module
class AnalyticModule {
  @Provides
  fun provideFirebase() = Firebase.analytics

  @Provides
  fun provideAnalytic(firebaseAnalytics: FirebaseAnalytics): Analytic =
    AnalyticImpl(firebaseAnalytics)
}