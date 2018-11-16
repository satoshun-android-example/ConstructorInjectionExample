package com.github.satoshun.example.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import javax.inject.Inject

@Suppress("ValidFragment")
class MainFragmentWithArgs(
  private val userHandler: UserHandler,
  private val userId: String
) : Fragment() {
  class Factory @Inject constructor(
    private val userHandler: UserHandler
  ) {
    fun create(args: Bundle) = MainFragmentWithArgs(
      userHandler = userHandler,
      userId = args.getString("user_id")!!
    ).also { it.arguments = args }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<TextView>(R.id.count).text = " $userId: ${userHandler.count()}"
  }
}
