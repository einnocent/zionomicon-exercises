package chapter02

import zio.*

object Exercise15 {
  /**
   * Using ZIO.async, convert the following asynchronous, callback-based func- tion into a ZIO function:
   */

  trait User

  def saveUserRecord(
    user: User,
    onSuccess: () => Unit, onFailure: Throwable => Unit
  ): Unit = ???

  def saveUserRecordZio(user: User): ZIO[Any, Throwable, Unit] = ZIO.async { callback =>
    saveUserRecord(
      user,
      () => callback(ZIO.succeed(())),
      e => callback(ZIO.fail(e))
    )
  }
}
