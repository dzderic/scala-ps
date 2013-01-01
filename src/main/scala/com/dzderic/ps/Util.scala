package com.dzderic.ps

import java.io.File

object Util {
  def readEntireFile(file: File): String = {
    val source = scala.io.Source.fromFile(file)
    val contents = source.mkString
    source.close()
    contents
  }
}
