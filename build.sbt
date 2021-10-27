name := "zionomicon-exercises"

version := "0.1"

scalaVersion := "3.0.0"

libraryDependencies ++= {
  val zio  = "dev.zio"
  val zioVersion = "2.0.0-M1"
  List(
    zio %% "zio" % zioVersion,
    zio %% "zio-test" % zioVersion,
    zio %% "zio-test-sbt" % zioVersion
  )
}

lazy val root = (project in file("."))
  .settings(
    name := "Hello"
//    ,
//    scalaVersion := "2.12.7"
  )