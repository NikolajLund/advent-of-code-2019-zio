package io.nilu.adventofcode.model.program

case class IntCodeProgram(state: List[Int], cursor: Int) {

  val OpCode: OpCode = {
    state(cursor) match {
      case 99 => FinishedOpCode
      case code => ExecutableOpCode(code, state(state(cursor + 1)), state(state(cursor + 2)), state(cursor + 3))
    }
  }

  override def toString: String = state.mkString(",")
}

object IntCodeProgram {
  private[this] val nextOpJump = 4

  def apply(stateString: String): IntCodeProgram =
    IntCodeProgram(stateString.split(",").map(_.toInt).toList, 0)


  def executeProgram(intCodeProgram: IntCodeProgram): IntCodeProgram = {
    intCodeProgram.OpCode match {
      case FinishedOpCode =>
        intCodeProgram
      case ExecutableOpCode(code, param1, param2, param3) =>
          val result = code match {
            case 1 => param1 + param2
            case _ => param1 * param2
          }
          val newState = intCodeProgram.state.updated(param3, result)
          executeProgram(IntCodeProgram(newState, intCodeProgram.cursor + nextOpJump))
    }
  }
}
