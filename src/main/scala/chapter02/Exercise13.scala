package chapter02

import zio.*

object Exercise13 {

  /**
   * Using ZIO.succeed, convert the following procedural function into a ZIO function:
   */
  def currentTime(): Long = java.lang.System.currentTimeMillis()

  lazy val currentTimeZIO: ZIO[Any, Nothing, Long] = ZIO.succeed(java.lang.System.currentTimeMillis())
}
