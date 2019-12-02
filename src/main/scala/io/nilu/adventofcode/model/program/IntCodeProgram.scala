package io.nilu.adventofcode.model.program

case class IntCodeProgram(memory: List[Int], instructionPointer: Int) {

  val instruction: Instruction = {
    memory(instructionPointer) match {
      case 99 => FinishedInstruction
      case code => ExecutableInstruction(code, memory(memory(instructionPointer + 1)), memory(memory(instructionPointer + 2)), memory(instructionPointer + 3))
    }
  }

  override def toString: String = memory.mkString(",")
}

object IntCodeProgram {
  def apply(stateString: String): IntCodeProgram =
    IntCodeProgram(stateString.split(",").map(_.toInt).toList, 0)


  def executeProgram(intCodeProgram: IntCodeProgram): IntCodeProgram = {
    intCodeProgram.instruction match {
      case FinishedInstruction =>
        intCodeProgram
      case ExecutableInstruction(code, param1, param2, param3) =>
          val result = code match {
            case 1 => param1 + param2
            case _ => param1 * param2
          }
          val newState = intCodeProgram.memory.updated(param3, result)
          executeProgram(IntCodeProgram(newState, intCodeProgram.instructionPointer + intCodeProgram.instruction.numberOfValuesInInstruction))
    }
  }
}
