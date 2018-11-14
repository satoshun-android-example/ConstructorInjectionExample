package com.github.satoshun.example.sample

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.github.satoshun.example.sample.databinding.MainActBinding
import javax.inject.Inject

class MainActivity @Inject constructor(
  private val fragmentFactory: MainFragmentFactory,
  private val viewFactory: MainTextViewFactory
) : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
//    DaggerAppComponent.create().inject(this)
    supportFragmentManager.fragmentFactory = fragmentFactory
    layoutInflater.factory = viewFactory
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil.setContentView<MainActBinding>(this, R.layout.main_act)
    val component = DaggerAppComponent.create()

    if (savedInstanceState == null) {
      supportFragmentManager.commit {
        add(R.id.fragment, fragmentFactory.fragment.get())
      }
    }
  }
}
