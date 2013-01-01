package com.dzderic.ps

import java.nio.file.attribute.{UserPrincipal, GroupPrincipal}
import java.util.Date

trait Process {
  val pid: Long                    // the process id

  val startTime: Date              // the starting time of the process

  val user: UserPrincipal          // the user running the process
  val group: GroupPrincipal        // the group associated with the process

  val cmdline: String              // the command-line used to launch the process
  val executable: Option[String]   // the executable the process is executing
  val cwd: Option[String]          // the working directory of the process
}