package io.nilu.adventofcode.model.program

sealed trait OpCode

final case class ExecutableOpCode(
                             code: Int,
                             param1: Int,
                             param2: Int,
                             param3: Int
                           ) extends OpCode

case object FinishedOpCode extends OpCode


