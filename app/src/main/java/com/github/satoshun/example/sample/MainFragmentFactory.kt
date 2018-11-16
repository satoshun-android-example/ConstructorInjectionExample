package com.github.satoshun.example.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentFactory @Inject constructor(
  private val factory: Provider<MainFragment>,
  val withArgs: MainFragmentWithArgs.Factory
) : FragmentFactory() {
  override fun instantiate(
    classLoader: ClassLoader,
    className: String,
    args: Bundle?
  ): Fragment {
    if (className == MainFragment::class.java.name) {
      return factory.get()
    }
    if (className == MainFragmentWithArgs::class.java.name) {
      return withArgs.create(args!!)
    }
    return super.instantiate(classLoader, className, args)
  }
}
