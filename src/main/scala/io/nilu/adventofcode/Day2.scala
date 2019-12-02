package io.nilu.adventofcode

import io.nilu.Utils
import io.nilu.adventofcode.model.program.IntCodeProgram
import zio._
import zio.console.Console

object Day2 extends App {

  private[this] val inputResourcePath = "input/day_2"

  val executeProgramZ: ZIO[Console, Throwable, Unit] = for {
    input <- Utils.loadResourceLines(inputResourcePath).map(_.next())
    program = IntCodeProgram(input)
    restoredProgram = IntCodeProgram(program.memory.updated(1, 12).updated(2, 2), 0)
    result = IntCodeProgram.executeProgram(restoredProgram)
    _ <- console.putStrLn(result.toString)
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    executeProgramZ.fold(_ => 1, _ => 0)


}
