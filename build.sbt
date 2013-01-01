organization  := "com.dzderic"

name          := "scala-ps"

version       := "0.1"

scalaVersion  := "2.10.0"

resolvers ++= Seq(
  "typesafe repo"      at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.specs2"          %%  "specs2"        % "1.13"    % "test"
)
