scalaVersion := "2.13.1"

name := "advent-of-code-2019-zio"
organization := "io.nilu"
version := "1.0"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "1.0.0-RC17",
  "dev.zio" %% "zio-nio" % "0.4.0",
  "org.scalatest" %% "scalatest" % "3.2.0-M1" % Test
)
