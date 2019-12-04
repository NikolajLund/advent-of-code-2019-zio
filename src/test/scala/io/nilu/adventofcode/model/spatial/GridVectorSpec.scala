package io.nilu.adventofcode.model.spatial

import org.scalatest.flatspec.AnyFlatSpec

class GridVectorSpec extends AnyFlatSpec {

  val origo = Point(0, 0)

  behavior of "pathFrom"

  it should "return the path resulting from adding to x axis when moving right" in {
    assert(GridVector("R3").getPathFrom(origo) == Seq(Point(1, 0), Point(2, 0), Point(3, 0)))
  }

  it should "return the path resulting from subtracting from x axis when moving left" in {
    assert(GridVector("L3").getPathFrom(origo) == Seq(Point(-1, 0), Point(-2, 0), Point(-3, 0)))
  }

  it should "return the path resulting from adding to x axis when moving up" in {
    assert(GridVector("U3").getPathFrom(origo) == Seq(Point(0, 1), Point(0, 2), Point(0, 3)))
  }

  it should "return the path resulting from subtracting from y axis when moving down" in {
    assert(GridVector("D3").getPathFrom(origo) == Seq(Point(0, -1), Point(0, -2), Point(0, -3)))
  }
}
