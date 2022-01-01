package com.panhuk.analyticimpl

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.panhuk.analytic.Analytic

class AnalyticImpl(private val firebaseAnalytic: FirebaseAnalytics): Analytic {
  override fun logEvent() {
    firebaseAnalytic.logEvent("hello", Bundle())
  }

  override fun logUserProperties() {
    firebaseAnalytic.setUserProperty("User", "Property")
  }
}