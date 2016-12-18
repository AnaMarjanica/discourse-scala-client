/**
  * Code coverage
  * Run jacoco:check jacoco:cover jacoco:report
  */
addSbtPlugin("de.johoop" % "jacoco4sbt" % "2.2.0")

/**
  * Scala style guide check
  *
  */
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")

/**
  * Release plugin
  *
  * https://github.com/sbt/sbt-release
  */
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.3")