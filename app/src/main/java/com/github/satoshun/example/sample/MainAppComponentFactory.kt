package com.github.satoshun.example.sample

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.core.app.AppComponentFactory

@Suppress("unused")
class MainAppComponentFactory : AppComponentFactory() {
  private lateinit var application: App

  override fun instantiateActivityCompat(
    cl: ClassLoader,
    className: String,
    intent: Intent?
  ): Activity {
    if (className.endsWith("MainActivity")) {
      return application.appComponent.mainActivity
    }
    return super.instantiateActivityCompat(cl, className, intent)
  }

  override fun instantiateApplicationCompat(cl: ClassLoader, className: String): Application {
    application = super.instantiateApplicationCompat(cl, className) as App
    return application
  }
}
