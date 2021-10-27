package chapter02

import zio.*
import zio.{App => ZIOApp}

/**
 * Using the Console and Random services in ZIO, write a little program that asks the user to guess a randomly chosen
 * number between 1 and 3, and prints out if they were correct or not.
 */
object Exercise18 extends ZIOApp {

  def run(args: List[String]) = {
    (for {
      _ <- Console.printLine("Guess a number between 1 and 3 (inclusive)")
      input <- Console.readLine
      number <- ZIO.attempt(input.toLong)
      rando <- Random.nextLongBounded(3).map(_ + 1)
      _ <- if (number == rando) Console.printLine(s"You were correct!") else Console.printLine(s"You were wrong! The number was $rando")
    } yield ()
      ).exitCode
  }

}
