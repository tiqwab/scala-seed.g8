// scalacOptions
// See `scalac -help`, `scalac -X`, or `scalac -Y`
lazy val commonScalacOptions = Seq(
  "-feature" // Emit warning and location for usages of features that should be imported explicitly.
  , "-deprecation" // Emit warning and location for usages of deprecated APIs.
  , "-unchecked" // Enable additional warnings where generated code depends on assumptions.
  , "-Xlint"
  , "-encoding" // Specify encoding of source files
  , "UTF-8"
  // , "-Xfatal-warnings"
  , "-language:_"
  , "-Wdead-code" // Warn when dead code is identified.
  , "-Wnumeric-widen" // Warn when numerics are widened.
)

lazy val commonSettings = Seq(
  organization := "$organization$",
  scalaVersion := "2.13.3",
  version      := "0.1.0-SNAPSHOT",
  scalacOptions := commonScalacOptions,
  scalacOptions in (Compile, console) -= "-Xlint:warn-unused",
  scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value
)

lazy val versions = new {
    val logback = "1.2.3"
    val scalaLogging = "3.9.2"
    val scalaTest = "3.2.0"
}

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "$name$",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % versions.logback,
      "com.typesafe.scala-logging" %% "scala-logging" % versions.scalaLogging,
      "org.scalatest" %% "scalatest" % versions.scalaTest % Test
    )
  )
