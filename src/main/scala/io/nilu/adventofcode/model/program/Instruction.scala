package io.nilu.adventofcode.model.program

sealed trait Instruction {
  val numberOfValuesInInstruction: Int
}

final case class ExecutableInstruction(
                                        opCode: Int,
                                        param1: Int,
                                        param2: Int,
                                        param3: Int
                           ) extends Instruction {
  override val numberOfValuesInInstruction: Int = 4
}

case object FinishedInstruction extends Instruction {
  override val numberOfValuesInInstruction: Int = 1
}


