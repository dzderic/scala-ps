package com.dzderic.ps

import java.io.File

object Util {
  def readEntireFile(file: File): String = {
    val source = scala.io.Source.fromFile(file)
    val contents = source.mkString
    source.close()
    contents
  }

  def maybeReadProtectedLink(link: File): Option[String] = {
    // Since `getCanonicalPath' fails silently, we check that we've properly
    // resolved the symlink by comparing it to the original file path
    val symlinkDest = link.getCanonicalPath
    if (link.getPath != symlinkDest) {
     Some(symlinkDest)
    } else {
      None
    }
  }
}