package io.nilu

import org.scalatest.flatspec.AnyFlatSpec

class Day1Spec extends AnyFlatSpec {

  behavior of "getFuelRequiredForMass"

  it should "calculate the correct amount of fuel required for a mass of 12" in {
    val solution = 2
    assert(Day1.getFuelRequiredForMass(12) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 14" in {
    val solution = 2
    assert(Day1.getFuelRequiredForMass(14) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 1969" in {
    val solution = 654
    assert(Day1.getFuelRequiredForMass(1969) == solution)
  }

  it should "calculate the correct amount of fuel required for a mass of 100756" in {
    val solution = 33583
    assert(Day1.getFuelRequiredForMass(100756) == solution)
  }

  behavior of "getFuelRequiredForMassRec"

  it should "recursively calculate the correct amount of fuel required for a mass of 14" in {
    val solution = 2
    assert(Day1.getFuelRequiredForMassRec(14) == solution)
  }

  it should "recursively calculate the correct amount of fuel required for a mass of 1969" in {
    val solution = 966
    assert(Day1.getFuelRequiredForMassRec(1969) == solution)
  }

  it should "recursively calculate the correct amount of fuel required for a mass of 100756" in {
    val solution = 50346
    assert(Day1.getFuelRequiredForMassRec(100756) == solution)
  }
}
