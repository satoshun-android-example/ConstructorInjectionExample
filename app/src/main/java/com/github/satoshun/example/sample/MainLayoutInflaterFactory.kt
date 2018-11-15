package com.github.satoshun.example.sample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import javax.inject.Inject

class MainLayoutInflaterFactory @Inject constructor(
  private val factory: MainTextView.Factory
) : LayoutInflater.Factory {
  override fun onCreateView(name: String, context: Context, attrs: AttributeSet?): View? {
    if (name == MainTextView::class.java.name) {
      return factory.create(context)
    }
    return null
  }
}
