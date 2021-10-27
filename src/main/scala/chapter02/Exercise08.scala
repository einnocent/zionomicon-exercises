package chapter02

//import zio.*

object Exercise08
  extends App
{

  /**
   * Implement the foreach function in terms of the toy model of a ZIO effect. The function should return an effect that
   * sequentially runs the specified function on every element of the specified collection.
   */
  def foreach[R, E, A, B](
    in: Iterable[A]
  )(f: A => ZIO[R, E, B]): ZIO[R, E, List[B]] = 
    Exercise07.collectAll(in.map(a => f(a)))

  val s = List(1, 2, 3)
  val res = foreach(s)(i => ZIO(r => Right(s"You are $i and $r"))).run(4)
  println(res)
  println("done!")
}
