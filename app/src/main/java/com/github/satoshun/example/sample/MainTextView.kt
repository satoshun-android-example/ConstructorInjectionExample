package com.github.satoshun.example.sample

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class MainTextView(
  context: Context,
  private val userHandler: UserHandler
) : TextView(context) {
  class Factory @Inject constructor(private val userHandler: UserHandler) {
    fun create(context: Context): MainTextView {
      return MainTextView(context, userHandler)
    }
  }

  init {
    text = userHandler.count()
  }
}
