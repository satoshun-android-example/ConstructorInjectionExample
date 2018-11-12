package com.github.satoshun.example.sample

import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
  fun handler(): UserHandlerWrapper
}

@Singleton
class UserHandler @Inject constructor() {
  private var c: Int = 0

  fun count(): String {
    c += 1
    return c.toString()
  }
}

class UserHandlerWrapper @Inject constructor(
  private val handler: UserHandler
) {
  fun showName() {
    println(handler.count())
  }
}
