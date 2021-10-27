package chapter02

import zio.*

object Exercise02 extends App {
  def run(args: List[String]) = {
    (for {
      time <- Clock.currentDateTime
      _ <- Console.printLine(s"args: $args")
      _ <- writeFileZio(args.head, s"hello! ${time}")
      _ <- Console.printLine("done!")
    } yield ())
      .exitCode
  }
  def writeFile(file: String, text: String): Unit = { import java.io._
    val pw = new PrintWriter(new File(file))
    try pw.write(text) finally pw.close
  }

  def writeFileZio(file: String, text: String): Task[Unit] = Task { import java.io._
    val pw = new PrintWriter(new File(file))
    try pw.write(text) finally pw.close
  }
}
