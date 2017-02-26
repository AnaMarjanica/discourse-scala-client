name := "discourse-scala-client"

organization := "com.amarjanica"

scalaVersion := "2.11.8"

crossScalaVersions := List("2.10.6", "2.11.8", "2.12.0")

resolvers += "Central" at "http://central.maven.org/maven2"

scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8"
)

scalacOptions in(Compile, doc) ++= Seq("-groups", "-implicits")

unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value)

unmanagedSourceDirectories in Test := List((scalaSource in Test).value)

libraryDependencies ++= Seq(
  "com.squareup.okhttp" % "okhttp" % "2.7.5",
  "org.specs2" %% "specs2-core" % "3.8.8" % "test",
  "org.specs2" %% "specs2-mock" % "3.8.8" % "test",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.7"
)

coverageEnabled := true

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseCrossBuild := true
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(action = Command.process("publishSigned", _)),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(action = Command.process("sonatypeReleaseAll", _)),
  pushChanges
)
