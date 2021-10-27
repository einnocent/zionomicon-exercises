package chapter02

import zio.*
import java.io.IOException

/**
 * Using the Console service and recursion, write a function that will repeat- edly read input from the console until
 * the specified user-defined function evaluates to true on the input.
 */
object Exercise19 extends zio.App {

  def readUntil(
    acceptInput: String => Boolean
  ): ZIO[Has[Console], IOException, String] =
    (for {
      input <- Console.readLine
      result <- if (acceptInput(input)) ZIO.succeed(input) else readUntil(acceptInput)
    } yield result)

  def run(args: List[String]) = {
    (for {
      _ <- readUntil(_ == "Erik")
    } yield ()).exitCode
  }
}