package com.github.satoshun.example.sample

import android.app.Activity
import android.content.Intent
import androidx.core.app.AppComponentFactory

class MainAppComponentFactory : AppComponentFactory() {
  override fun instantiateActivityCompat(
    cl: ClassLoader,
    className: String,
    intent: Intent?
  ): Activity {
    if (className.endsWith("MainActivity")) {
      return MainActivity()
    }
    return super.instantiateActivityCompat(cl, className, intent)
  }
}