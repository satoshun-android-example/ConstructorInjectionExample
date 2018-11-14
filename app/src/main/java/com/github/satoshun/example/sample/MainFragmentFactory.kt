package com.github.satoshun.example.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentFactory @Inject constructor(
  val fragment: Provider<MainFragment>
) : FragmentFactory() {
  override fun instantiate(
    classLoader: ClassLoader,
    className: String,
    args: Bundle?
  ): Fragment {
    if (className.endsWith("MainFragment")) {
      return fragment.get()
    }
    return super.instantiate(classLoader, className, args)
  }
}