package com.panhuk.analyticimpl

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.panhuk.analytic.Analytic

class AnalyticImpl(private val firebaseAnalytic: FirebaseAnalytics) : Analytic {

  override fun logEvent(eventName: String, bundle: Bundle) {
    firebaseAnalytic.logEvent(eventName, bundle)
  }

  override fun logUserProperties(eventName: String, eventDescription: String) {
    firebaseAnalytic.setUserProperty(eventName, eventDescription)
  }
}