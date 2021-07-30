import JavaOptions._
import ScalaOptions._
import Dependencies._

ThisBuild / organization := "com.ensime"
ThisBuild / scalafixDependencies ++= rules

lazy val root = (project in file("."))
  .settings( // main
    name := "luaj",
    scalaVersion := "2.13.6",
    scalacOptions ++= scalaCompilerOptions,
    conflictManager := ConflictManager.strict,
    libraryDependencies ++= luajc ::: tests,
    dependencyOverrides ++= overrides,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )
  .settings( // jar
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := {
      val jarName    = name.value
      val appVersion = version.value

      s"$jarName-$appVersion.jar"
    },
    assemblyExcludedJars in assembly := (fullClasspath in assembly).value.filter {
      _.data.getName.startsWith("SystematicChaos")
    },
    test in assembly := {}
  )
  .settings( // test
    fork in Test := true,
    javaOptions in Test ++= hotSpotOptions,
    logBuffered in Test := false
  )
  .enablePlugins(JavaCCPlugin)
