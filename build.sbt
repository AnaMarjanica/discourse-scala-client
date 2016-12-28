import de.johoop.jacoco4sbt.{HTMLReport, XMLReport,ScalaHTMLReport}

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

scalacOptions in (Compile,doc) ++= Seq("-groups", "-implicits")

unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value)

unmanagedSourceDirectories in Test := List((scalaSource in Test).value)

libraryDependencies ++= Seq(
  "com.squareup.okhttp" % "okhttp" % "2.7.5",
  "org.specs2" %% "specs2-core" % "3.8.5" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.5",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)

testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Spec")))

jacoco.settings

parallelExecution in jacoco.Config := false

jacoco.reportFormats in jacoco.Config := Seq(
  XMLReport(encoding = "utf-8"),
  HTMLReport("utf-8"),
  ScalaHTMLReport(withBranchCoverage = true))

jacoco.excludes in jacoco.Config := Seq(
  "assets*","views*", "*Routes*", "controllers*routes*", "controllers*Reverse*",
  "controllers*javascript*", "controller*ref*"
)

addCommandAlias("coverage", "; jacoco:check; jacoco:cover; jacoco:report")

import ReleaseTransformations._

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
