package com.dzderic.ps

import java.nio.file.attribute.{UserPrincipal, GroupPrincipal}

trait Process {
  val pid: Long
  val startTime: Long

  val user: UserPrincipal
  val group: GroupPrincipal

  val cmdline: String
  val executable: Option[String]
  val cwd: Option[String]
}