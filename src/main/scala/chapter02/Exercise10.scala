package chapter02

import zio.{ExitCode, Task, URIO, App as ZIOApp, ZIO, Console}

object Exercise10
  extends ZIOApp {

  /**
   * Using the following code as a foundation, write a ZIO application that prints out the contents of whatever files
   * are passed into the program as command-line arguments. You should use the function readFileZio that you developed
   * in these exercises, as well as ZIO.foreach.
   */
  def run(commandLineArguments: List[String]) = {
    val y = ZIO.foreach(commandLineArguments)(Exercise03.readFileZio)
      .flatMap(x => ZIO.foreach(x)(y => Console.printLine(y)))
    (for {
      _ <- y
    } yield ()).exitCode
      .exitCode

  }
}