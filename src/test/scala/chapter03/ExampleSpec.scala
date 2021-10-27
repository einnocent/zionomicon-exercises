package chapter03

import zio.*
import zio.test.*
import zio.test.environment.*
import zio.test.Assertion.*

class ExampleSpec extends DefaultRunnableSpec {
  def spec = suite("ExampleSpec")(
    test("addition works") {
      assert(1 + 1)(equalTo(2))
    },
    test("ZIO.succeed succeeds with specified value") {
      assertM(ZIO.succeed(1 + 1))(equalTo(2))
    },
    test("testing an effect using map operator") {
      ZIO.succeed(1 + 1).map(n => assert(n)(equalTo(2)))
    },
    test("testing an effect using a for comprehension") {
      for {
        n <- ZIO.succeed(1 + 1)
      } yield assert(n)(equalTo(2))
    }
  )

  import zio.Console._

  val greet: ZIO[Has[Console], Nothing, Unit] = for {
    name <- readLine.orDie
    _ <- printLine(s"Hello, $name!").orDie} yield ()


  def spec2 = suite("ExampleSpec2")(test("greet says hello to the user") {
    for {
      _ <- TestConsole.feedLines("Jane")
      _ <- greet
      value <- TestConsole.output
    } yield assert(value)(equalTo(Vector("Hello, Jane!\n")))
  }
  )
}