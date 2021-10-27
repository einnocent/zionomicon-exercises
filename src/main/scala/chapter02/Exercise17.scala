package chapter02

import zio.*
import zio.{App => ZIOApp}

object Exercise17 extends ZIOApp {

  /**
   * Using the Console, write a little program that asks the user what their name is, and then prints it out to them
   * with a greeting
   */
  def run(args: List[String]) = {
    (for {
      _ <- Console.printLine("What is your name?")
      name <- Console.readLine
      _ <- Console.printLine(s"Hello, $name!")
    } yield ()
      ).exitCode
  }
}
