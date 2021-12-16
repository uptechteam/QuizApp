package com.panhuk.quizapp

import android.app.Application
import android.content.Context
import com.panhuk.core.di.CoreComponent
import com.panhuk.repositorydi.firstTime.FirstTimeRepoComponent

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
        .firstTimeRepoComponent(FirstTimeRepoComponent.create(context)) // need to think
        .coreComponent(CoreComponent.create())
        .build()
    }
  }
}