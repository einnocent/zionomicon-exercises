package chapter02

final case class ZIO[-R, +E, +A](run: R => Either[E, A])
