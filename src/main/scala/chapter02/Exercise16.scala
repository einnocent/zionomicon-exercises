package chapter02

import scala.concurrent.{ExecutionContext, Future}
import zio.*

object Exercise16 {
  /**
   * Using ZIO.fromFuture, convert the following code to ZIO:
   */
  trait Query

  trait Result

  def doQuery(query: Query)(
    implicit ec: ExecutionContext): Future[Result] =
    ???

  def doQueryZio(query: Query): ZIO[Any, Throwable, Result] = ZIO.fromFuture { make =>
    doQuery(query)(make)
  }
}
