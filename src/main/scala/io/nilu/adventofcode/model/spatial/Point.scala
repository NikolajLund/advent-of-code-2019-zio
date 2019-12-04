package io.nilu.adventofcode.model.spatial

case class Point(x: Int, y: Int) {

  def manhattanDist(other: Point) = {
    Math.abs(x - other.x) + Math.abs(y - other.y)
  }
}
