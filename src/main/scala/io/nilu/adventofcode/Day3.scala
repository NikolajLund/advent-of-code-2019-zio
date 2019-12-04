package io.nilu.adventofcode

import io.nilu.Utils
import io.nilu.adventofcode.model.spatial.{GridVector, Point}
import zio._
import zio.console.Console

object Day3 extends App {
  val origo = Point(0, 0)

  def getPathPointsFromDirectionInputList(gridVectors: Array[GridVector]): Seq[Point] = {
    gridVectors.foldLeft(Seq(origo)){ case (acc, gridVector) =>
      val nextPath = gridVector.getPathFrom(acc.last)
      acc ++ nextPath
    }
  }

  def getMinimumDistanceFromIntersectionToOrigo(gridVectors1: Array[GridVector], gridVectors2: Array[GridVector]): Int = {
    val (wire1PathInput, wire2PathInput) = (getPathPointsFromDirectionInputList(gridVectors1), getPathPointsFromDirectionInputList(gridVectors2))
    val intersections = wire1PathInput.intersect(wire2PathInput)
    intersections.filterNot(_ == origo).map(origo.manhattanDist).min
  }

  private[this] val inputResourcePath = "input/day_3"

  val findMinimumDistanceFromIntersectionToStart: ZIO[Console, Throwable, Unit] = for {
    input <- Utils.loadResourceLines(inputResourcePath)
    wireGridVectorList = input.toArray.map(_.split(",").map(GridVector.apply))
    minimumDistanceToStart = getMinimumDistanceFromIntersectionToOrigo(wireGridVectorList(0), wireGridVectorList(1))
    _ <- console.putStrLn(s"Distance to intersection closest to start: $minimumDistanceToStart")
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    findMinimumDistanceFromIntersectionToStart.fold(_ => 1, _ => 0)
}
