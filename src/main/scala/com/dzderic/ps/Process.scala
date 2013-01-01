package com.dzderic.ps

import java.nio.file.attribute.{UserPrincipal, GroupPrincipal}

trait Process {
  val pid: Long                    // the process id

  val runTime: Long                // time (in milliseconds) that the process has been running for

  val user: UserPrincipal          // the user running the process
  val group: GroupPrincipal        // the group associated with the process

  val cmdline: String              // the command-line used to launch the process
  val executable: Option[String]   // the executable the process is executing
  val cwd: Option[String]          // the working directory of the process
}