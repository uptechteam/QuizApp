package com.panhuk.analyticdi

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.panhuk.analytic.Analytic
import com.panhuk.analyticimpl.AnalyticImpl
import dagger.Module
import dagger.Provides

@Module
class AnalyticModule {
  @Provides
  fun provideFirebase(context: Context) =
    FirebaseAnalytics.getInstance(context)

  @Provides
  fun provideAnalytic(firebaseAnalytics: FirebaseAnalytics): Analytic =
    AnalyticImpl(firebaseAnalytics)
}