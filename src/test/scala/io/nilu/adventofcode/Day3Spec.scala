package io.nilu.adventofcode

import io.nilu.adventofcode.model.spatial.GridVector
import org.scalatest.flatspec.AnyFlatSpec

class Day3Spec extends AnyFlatSpec {
  behavior of "getMinimumDistanceFromIntersectionToStart"

  it should "produce a distance of 159 for the input lists [R75,D30,R83,U83,L12,D49,R71,U7,L72] and [U62,R66,U55,R34,D71,R55,D58,R83]" in {
    val inputList1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",").map(GridVector.apply)
    val inputList2 = "U62,R66,U55,R34,D71,R55,D58,R83".split(",").map(GridVector.apply)

    assert(Day3.getMinimumDistanceFromIntersectionToOrigo(inputList1, inputList2) == 159)
  }

  it should "produce a distance of 159 for the input lists [R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51] and [U98,R91,D20,R16,D67,R40,U7,R15,U6,R7]" in {
    val inputList1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(",").map(GridVector.apply)
    val inputList2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(",").map(GridVector.apply)

    assert(Day3.getMinimumDistanceFromIntersectionToOrigo(inputList1, inputList2) == 135)
  }
}
