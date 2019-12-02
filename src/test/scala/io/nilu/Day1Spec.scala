package io.nilu

import org.scalatest.flatspec.AnyFlatSpec

class Day1Spec extends AnyFlatSpec {

  behavior of "getFuelRequired"

  it should "calculate the correct amount of fuel required for a mass of 12" in {
    val solution = 2
    assert(Day1.getFuelRequired(12) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 14" in {
    val solution = 2
    assert(Day1.getFuelRequired(14) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 1969" in {
    val solution = 654
    assert(Day1.getFuelRequired(1969) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 100756" in {
    val solution = 33583
    assert(Day1.getFuelRequired(100756) == solution)
  }

}
