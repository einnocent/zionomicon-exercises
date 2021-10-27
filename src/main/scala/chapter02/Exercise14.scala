package chapter02

import zio.*

object Exercise14 {

  /**
   * Using ZIO.async, convert the following asynchronous, callback-based function into a ZIO function:
   */
  def getCacheValue(
    key: String,
    onSuccess: String => Unit,
    onFailure: Throwable => Unit
  ): Unit = ???

  def getCacheValueZio(key: String): ZIO[Any, Throwable, String] = ZIO.async { callback =>
    getCacheValue(
      key,
      v => callback(ZIO.succeed(v)),
      e => callback(ZIO.fail(e))
    )
  }
}
