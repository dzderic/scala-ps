package com.dzderic.ps

import java.io.File

object LinuxProcessFactory extends ProcessFactory {
  val PROC_MOUNT = "/proc"

  def processes: Seq[Process] = {
    new File(PROC_MOUNT).listFiles().filter { file =>
      // Pull out directories that are made up of only digits
      file.isDirectory && file.getName.matches("^[0-9]+$")
    }.map { directory =>
      // TODO: Handle processes that die between the `listFiles` and here
      new LinuxProcess(directory.getName.toInt)
    }
  }
}
