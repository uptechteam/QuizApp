package com.panhuk.quizapp

import android.app.Application
import android.content.Context

class QuizApp : Application() {

  override fun onCreate() {
    super.onCreate()
    initializeComponent(applicationContext)
  }

  companion object {
    private lateinit var _component: ApplicationComponent
    val component: ApplicationComponent
      get() = _component

    private fun initializeComponent(context: Context) {
      _component = DaggerApplicationComponent.builder()
        .applicationContext(context)
        .build()
    }
  }
}