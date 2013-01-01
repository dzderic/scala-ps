package com.dzderic.ps

import java.nio.file.{Files, Paths}
import java.nio.file.attribute.PosixFileAttributes

class LinuxProcess(val pid: Long) extends Process {
  private val proc_path = Paths.get(LinuxProcessFactory.PROC_MOUNT, pid.toString)

  lazy private val attributes = {
    Files.readAttributes[PosixFileAttributes](proc_path, classOf[PosixFileAttributes])
  }
  lazy val user = attributes.owner()
  lazy val group = attributes.group()

  lazy val cmdline = Util.readEntireFile(proc_path.resolve("cmdline").toFile)

  // TODO: These
  lazy val executable = null
  lazy val cwd = null
}
