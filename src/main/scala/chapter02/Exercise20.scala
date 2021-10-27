package chapter02

import zio.*

/**
 * Using recursion, write a function that will continue evaluating the specified effect, until the specified
 * user-defined function evaluates to true on the output of the effect.
 */
object Exercise20 extends zio.App {

  def doWhile[R, E, A](
    body: ZIO[R, E, A]
  )(condition: A => Boolean): ZIO[R, E, A] =
    body.flatMap(
      a => if (condition(a)) ZIO.succeed(a) else doWhile(body)(condition)
    )

  def run(args: List[String]) = {
    (for {
      _ <- doWhile(Console.readLine)(_ == "Erik")
    } yield ()).exitCode
  }
}
