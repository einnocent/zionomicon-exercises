package chapter02

//import zio.*

object Exercise06
  extends App
{
  /**
   * Implement the zipWith function in terms of the toy model of a ZIO effect. The function should return an effect that
   * sequentially composes the specified effects, merging their results with the specified user-defined function.
   */
//    final case class ZIO[-R, +E, +A](run: R => Either[E, A])

    def zipWith[R, E, A, B, C](
      self: ZIO[R, E, A],
      that: ZIO[R, E, B]
    )(f: (A, B) => C): ZIO[R, E, C] = {
      ZIO(r => (self.run(r), that.run(r)) match {
        case (Right(a: A), Right(b: B)) => Right(f(a, b))
        case (Left(e: E), _) => Left(e)
        case (_, Left(e: E)) => Left(e)
      })
    }

//    def run(args: List[String]) = {
//final def main(args: Array[String]) = {
      println(s"args = $args")
      val a = ZIO(r => Right(s"a = $r"))
      val b = ZIO(r => Right(s"b = $r"))
      val e = ZIO(r => Left(s"e = $r"))

      val z = zipWith(e, a)({case (x: String, y: String) => x + y}).run(1)
      println(s"done! z = `$z`")
//    }
}
