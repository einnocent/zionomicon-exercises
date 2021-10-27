package chapter02

//import zio.*

object Exercise07
  extends App
  {
  /**
   * Implement the collectAll function in terms of the toy model of a ZIO effect. The function should return an effect
   * that sequentially collects the results of the specified collection of effects.
   */
//  final case class ZIO[-R, +E, +A](run: R => Either[E, A]) {
//  }

  def collectAll[R, E, A](
    in: Iterable[ZIO[R, E, A]]
  ): ZIO[R, E, List[A]] = {
    ZIO(r => {
      in.headOption.map(_.run(r)) match {
        case None => Right(Nil)
        case Some(Left(e)) => Left(e)
        case Some(Right(a)) =>
          collectAll(in.drop(1)).run(r) match {
            case Left(e) => Left(e)
            case Right(b) => Right(List(a) ++ b)
          }
      }
    })
  }

//  val s = List(
//    ZIO(i => Right(s"one is $i")),
//    ZIO(i => Right(s"two is $i")),
//    ZIO(i => Right(s"three is $i")),
//      ZIO(i => Left("problem!"))
//  )
//  val res = collectAll(s)
//  println(res.run("hi"))
//  println("done!")
}
