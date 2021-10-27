package chapter02

import zio.*

object Exercise03 extends App {
  def run(args: List[String]) = {
    (for {
      time <- Clock.currentDateTime
      _ <- Console.printLine(s"args: $args")
      _ <- copyFileZio(s"${args.head}.txt", s"${args.head}-copy.txt")
      _ <- Console.printLine("done!")
    } yield ())
      .exitCode
  }

//  def copyFile(source: String, dest: String): Unit = { val contents = readFile(source)
//    writeFile(dest, contents)
//  }

  def copyFileZio(source: String, dest: String): Task[Unit] =
    readFileZio(source)
      .flatMap { contents =>
        writeFileZio(dest, contents)
      }

  def readFileZio(file: String): Task[String] =
    ZIO.acquireReleaseWith(
      ZIO.attempt({Console.printLine(s"opening $file"); scala.io.Source.fromFile(file)}),
      source => URIO { source.close() },
      source => Task { source.getLines.mkString }
    )

  def writeFileZio(file: String, text: String): Task[Unit] = Task { import java.io.*
    val pw = new PrintWriter(new File(file))
    try pw.write(text) finally pw.close
  }
}
