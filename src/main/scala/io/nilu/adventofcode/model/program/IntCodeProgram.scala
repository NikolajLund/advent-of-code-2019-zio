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
          executeProgram(
            IntCodeProgram(
              newState,
              intCodeProgram.instructionPointer + intCodeProgram.instruction.numberOfValuesInInstruction)
          )
    }
  }

  def findNoun(programWithVerb: IntCodeProgram, expectedResult: Int,
                      nounUpperBound: Int, noun: Int): Either[Unit, IntCodeProgram] = {

    val programWithNoun = IntCodeProgram(programWithVerb.memory.updated(1, noun), 0)
    val executedProgram = IntCodeProgram.executeProgram(programWithNoun)

    executedProgram.memory(0) match {
      case expected if expected == expectedResult => Right(executedProgram)
      case _ if noun < nounUpperBound =>  {
        findNoun(programWithVerb, expectedResult, nounUpperBound, noun + 1)
      }
      case _ => Left(())
    }
  }

  def findNounAndVerb(initialIntCodeProgram: IntCodeProgram, expectedResult: Int,
                      nounUpperBound: Int, verbUpperBound: Int, verb: Int): Either[Unit, IntCodeProgram] = {

    val programWithVerb = IntCodeProgram(initialIntCodeProgram.memory.updated(2, verb), 0)
    findNoun(programWithVerb, expectedResult, nounUpperBound, 0) match {
      case Right(result) => Right(result)
      case _ if verb < verbUpperBound => findNounAndVerb(initialIntCodeProgram, expectedResult, nounUpperBound, verbUpperBound, verb + 1)
      case _ => Left(())
    }
  }
}
