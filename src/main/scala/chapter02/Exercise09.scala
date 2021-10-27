package chapter02

object Exercise09
  extends App
{
  /**
   * Implement the orElse function in terms of the toy model of a ZIO effect. The function should return an effect that
   * tries the left hand side, but if that effect fails, it will fallback to the effect on the right hand side.
   */
  def orElse[R, E1, E2, A](
    self: ZIO[R, E1, A],
    that: ZIO[R, E2, A]
  ): ZIO[R, E2, A] = ZIO(r =>
    self.run(r) match {
      case Right(a) => Right(a)
      case Left(_) => that.run(r)
    }
  )

  println(s"args = $args")
  val a = ZIO(r => Right(s"a = $r"))
  val b = ZIO(r => Right(s"b = $r"))
  val e = ZIO(r => Left(s"e = $r"))

  val z = orElse(e, b).run(1)
  println(s"done! z = `$z`")

}
