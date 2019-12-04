package io.nilu.adventofcode.model.spatial

case class GridVector(direction: Char, magnitude: Int) {

  def getPathFrom(point: Point): Seq[Point] = {
    val steps = 1 to magnitude

    direction match {
      case 'L' =>
        steps.map(step => point.copy(x = point.x - step))
      case 'R' =>
        steps.map(step => point.copy(x = point.x + step))
      case 'U' =>
        steps.map(step => point.copy(y = point.y + step))
      case 'D' =>
        steps.map(step => point.copy(y = point.y - step))
    }
  }
}

object GridVector {

  def apply(gridVectorString: String): GridVector = {
    GridVector(gridVectorString.head, gridVectorString.tail.toInt)
  }
}
