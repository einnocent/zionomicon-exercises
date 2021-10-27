package chapter02

import zio.*

object Exercise04
  extends App
{
  def run(args: List[String]) = {
//    (for {
//      time <- Clock.currentDateTime
//      _ <- Console.printLine(s"args: $args")
//      _ <- copyFileZio(s"${args.head}.txt", s"${args.head}-copy.txt")
//      _ <- Console.printLine("done!")
//    } yield ())
//      .exitCode
//  }
    def printLine(line: String) = ZIO.attempt(println(line))
    val readLine = ZIO.attempt(scala.io.StdIn.readLine())
    (for {
      _ <- printLine("What is your name?")
      name <- readLine
      _ <- printLine(s"Hello, ${name}!")
    } yield ()).exitCode
  }
}
