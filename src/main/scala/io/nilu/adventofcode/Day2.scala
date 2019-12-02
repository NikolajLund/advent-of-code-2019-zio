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

  val exploreProgramZ: ZIO[Console, Throwable, Unit] = for {
    input <- Utils.loadResourceLines(inputResourcePath).map(_.next())
    initialProgram = IntCodeProgram(input)
    resultE = IntCodeProgram.findNounAndVerb(initialProgram, 19690720, 99, 99, 0)
    _ <- resultE match {
      case Right(result) => console.putStrLn(s"Noun: ${result.memory(1)}, Verb: ${result.memory(2)}, Check: ${100 * result.memory(1) + result.memory(2)}")
      case Left(_) => console.putStrLn("No configuration found matching the result")
    }
  } yield ()

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    exploreProgramZ.fold(_ => 1, _ => 0)


}
