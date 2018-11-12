package com.github.satoshun.example.sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import com.github.satoshun.example.sample.databinding.MainActBinding
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : BaseActivity() {
  @Inject lateinit var factory: MainFragmentFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    DaggerAppComponent.create().inject(this)
    supportFragmentManager.fragmentFactory = factory
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil.setContentView<MainActBinding>(this, R.layout.main_act)
    val component = DaggerAppComponent.create()

    if (savedInstanceState == null) {
      supportFragmentManager.commit {
        add(R.id.fragment, factory.fragment.get())
      }
    }
  }
}

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

class MainFragment @Inject constructor(
  private val userHandler: UserHandler
) : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<TextView>(R.id.count).text = userHandler.count().toString()
  }
}
