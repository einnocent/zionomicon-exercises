package chapter02

import zio.*

object Exercise11 extends zio.App {

  /**
   * Using ZIO.fail and ZIO.succeed, implement the following function, which converts an Either into a ZIO effect:
   */

  def run(commandLineArguments: List[String]) = {
???
  }

  def eitherToZIO[E, A](either: Either[E, A]): ZIO[Any, E, A] = {
    either match {
      case Left(e) => ZIO.fail(e)
      case Right(a) => ZIO.succeed(a)
    }
  }
}
