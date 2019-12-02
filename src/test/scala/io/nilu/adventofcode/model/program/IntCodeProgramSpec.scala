package io.nilu.adventofcode.model.program

import org.scalatest.flatspec.AnyFlatSpec

class IntCodeProgramSpec extends AnyFlatSpec {

  behavior of "executeProgram"

  it should "produce correct outcome state for program [1,9,10,3,2,3,11,0,99,30,40,50]" in {
    val program = IntCodeProgram("1,9,10,3,2,3,11,0,99,30,40,50")
    val executed = IntCodeProgram.executeProgram(program)
    assert(executed.toString == "3500,9,10,70,2,3,11,0,99,30,40,50")
  }

  it should "produce correct outcome state for program [1,0,0,0,99]" in {
    val program = IntCodeProgram("1,0,0,0,99")
    val executed = IntCodeProgram.executeProgram(program)
    assert(executed.toString == "2,0,0,0,99")
  }

  it should "produce correct outcome state for program [2,3,0,3,99]" in {
    val program = IntCodeProgram("2,3,0,3,99")
    val executed = IntCodeProgram.executeProgram(program)
    assert(executed.toString == "2,3,0,6,99")
  }

  it should "produce correct outcome state for program [2,4,4,5,99,0]" in {
    val program = IntCodeProgram("2,4,4,5,99,0")
    val executed = IntCodeProgram.executeProgram(program)
    assert(executed.toString == "2,4,4,5,99,9801")
  }

  it should "produce correct outcome state for program [1,1,1,4,99,5,6,0,99]" in {
    val program = IntCodeProgram("1,1,1,4,99,5,6,0,99")
    val executed = IntCodeProgram.executeProgram(program)
    assert(executed.toString == "30,1,1,4,2,5,6,0,99")
  }
}
