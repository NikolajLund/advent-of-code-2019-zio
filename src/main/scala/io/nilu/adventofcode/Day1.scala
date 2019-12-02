package io.nilu.adventofcode

import io.nilu.Utils
import zio.console.Console
import zio.{App, ZIO, console}

object Day1 extends App {

  private[this] val inputResourcePath = "input/day_1"

  private[nilu] def getFuelRequiredForMass(mass: Int): Int = Math.max(mass / 3 - 2, 0)

  private[nilu] def getFuelRequiredForMassRec(mass: Int): Int = {
    val fuelRequiredForMass = getFuelRequiredForMass(mass)
    if (fuelRequiredForMass > 0) {
      fuelRequiredForMass + getFuelRequiredForMassRec(fuelRequiredForMass)
    } else {
      fuelRequiredForMass
    }
  }

  val calculateFuelRequiredZ: ZIO[Console, Throwable, Iterator[String]] = for {
    input <- Utils.loadResourceLines(inputResourcePath)
    masses = input.map(_.toInt)
    fuelRequired = masses.map(getFuelRequiredForMassRec).sum
    _ <- console.putStrLn(s"Total fuel requirement: $fuelRequired")
  } yield input

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    calculateFuelRequiredZ.fold(_ => 1, _ => 0)
}
