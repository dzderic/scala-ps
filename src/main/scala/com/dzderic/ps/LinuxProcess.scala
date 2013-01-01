package com.dzderic.ps

import java.nio.file.{Files, Paths}
import java.nio.file.attribute.PosixFileAttributes

class LinuxProcess(val pid: Long) extends Process {
  // Path pointing to /proc/<pid>
  private val proc_path = Paths.get(LinuxProcessFactory.PROC_MOUNT, pid.toString)

  // Get the process user/group from the /proc/<pid> directory permissions
  lazy private val attributes = {
    Files.readAttributes[PosixFileAttributes](proc_path, classOf[PosixFileAttributes])
  }
  lazy val user = attributes.owner()
  lazy val group = attributes.group()

  // `cmdline' is split by null's. Change them to spaces.
  lazy val cmdline = Util.readEntireFile(proc_path.resolve("cmdline").toFile).replace('\0', ' ').trim

  // `exe' and `cwd' are symlinks which are only readable by the same user
  // running the process, which is why they're Option's
  lazy val executable = Util.maybeReadProtectedLink(proc_path.resolve("exe").toFile)
  lazy val cwd = Util.maybeReadProtectedLink(proc_path.resolve("cwd").toFile)
}
