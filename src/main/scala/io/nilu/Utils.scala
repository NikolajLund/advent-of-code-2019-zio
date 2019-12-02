package io.nilu

import zio.Task

import scala.io.Source

object Utils {

  def loadResourceLines(resourcePath: String): Task[Iterator[String]] = {
    Task(Source.fromResource(resourcePath).getLines)
  }
}
