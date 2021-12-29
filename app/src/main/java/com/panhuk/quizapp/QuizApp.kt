package com.panhuk.quizapp

import android.app.Application
import timber.log.Timber

class QuizApp : Application() {

  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
  }
}