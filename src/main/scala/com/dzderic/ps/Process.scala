package com.dzderic.ps

import java.nio.file.attribute.UserPrincipal

trait Process {
  val pid: Long

  val user: UserPrincipal
  val group: UserPrincipal

  val exe: String
  val cmdline: String
  val cwd: String
}