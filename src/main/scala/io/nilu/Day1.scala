package io.nilu

import zio._
import zio.console.Console

object Day1 extends App {

  private[this] val inputResourcePath = "input/day_1"

  private[nilu] def getFuelRequired(mass: Int): Int = mass / 3 - 2

  val calculateFuelRequiredZ: ZIO[Console, Throwable, Iterator[String]] = for {
    input <- Utils.loadResourceLines(inputResourcePath)
    masses = input.map(_.toInt)
    fuelRequired = masses.map(getFuelRequired).sum
    _ <- console.putStrLn(s"Total fuel requirement: $fuelRequired")
  } yield input

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    calculateFuelRequiredZ.fold(_ => 1, _ => 0)
}
