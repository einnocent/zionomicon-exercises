package chapter02

import zio.*

object Exercise05
  extends App
{
  def run(args: List[String]) = {
    val random = ZIO.attempt(scala.util.Random.nextInt(3) + 1)
    def printLine(line: String) = ZIO.attempt(println(line))
    val readLine = ZIO.attempt(scala.io.StdIn.readLine())

    (for {
      int <- random
      _ <- printLine("Guess a number from 1 to 3:")
      num <- readLine
      _ <- if (num == int.toString) printLine("You guessed right!") else printLine(s"You guessed wrong, the number was $int!")
    } yield ()).exitCode
  }
}
