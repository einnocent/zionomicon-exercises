package chapter02

import zio.*

object Exercise01 extends App {
  def run(args: List[String]) = {
    (for {
      str <- readFileZioAttemptOnly(args.tail.head)
      _ <- Console.printLine(str)
    } yield ())
      .exitCode
  }

  def readFileZio(file: String): Task[String] =
    ZIO.acquireReleaseWith(
      ZIO.attempt(scala.io.Source.fromFile(file)),
      source => URIO { source.close() },
      source => Task { source.getLines.mkString }
    )

  def readFileZioAttemptOnly(file: String): Task[String] =
    ZIO.attempt {
      val source = scala.io.Source.fromFile(file)
      try source.getLines.mkString finally source.close()
    }

  def readFile(file: String): String = {
    val source = scala.io.Source.fromFile(file)
    try source.getLines.mkString finally source.close()
  }
}
