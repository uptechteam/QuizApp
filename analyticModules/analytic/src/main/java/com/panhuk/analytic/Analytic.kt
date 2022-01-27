package com.panhuk.analytic

import android.os.Bundle

interface Analytic {
  fun logEvent(eventName: String, bundle: Bundle)
  fun logUserProperties(eventName: String, eventDescription: String)
}