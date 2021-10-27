package chapter02

import zio.*

object Exercise12 extends App {
  /**
   * Using ZIO.fail and ZIO.succeed, implement the following function, which converts a List into a ZIO effect, by
   * looking at the head element in the list and ignoring the rest of the elements.
   */
  def listToZIO[A](list: List[A]): ZIO[Any, None.type, A] = {
    list.headOption match {
      case Some(a) => ZIO.succeed(a)
      case None => ZIO.fail(None)
    }
  }


  def run(commandLineArguments: List[String]) = {
???
  }


}