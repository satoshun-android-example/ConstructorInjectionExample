package com.github.satoshun.example.sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import com.github.satoshun.example.sample.databinding.MainActBinding

class MainActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    supportFragmentManager.fragmentFactory = MainFragmentFactory()

    val binding = DataBindingUtil.setContentView<MainActBinding>(this, R.layout.main_act)
    val component = DaggerAppComponent.create()

    if (savedInstanceState == null) {
      supportFragmentManager.commit {
        add(R.id.fragment, MainFragment("test"))
      }
    }
  }
}

class MainFragmentFactory : FragmentFactory() {
  override fun instantiate(
    classLoader: ClassLoader,
    className: String,
    args: Bundle?
  ): Fragment {
    if (className.endsWith("MainFragment")) {
      return MainFragment("hoge")
    }
    return super.instantiate(classLoader, className, args)
  }
}

class MainFragment(private val name: String) : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.main_frag, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
