package com.dzderic.ps

import java.nio.file.attribute.{UserPrincipal, GroupPrincipal}

trait Process {
  val pid: Long

  val user: UserPrincipal
  val group: GroupPrincipal

  val exe: String
  val cmdline: String
  val cwd: String
}