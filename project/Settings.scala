import sbt._
import sbt.Keys._
import sbtbuildinfo.Plugin._
import sbtscalaxb.Plugin._
import sbtscalaxb.Plugin.ScalaxbKeys._
import java.io.File

object Settings {

  import Dependencies._

  val appDependencies = compileDeps ++ testDeps

  lazy val SharedTest = config("shared") extend (Test)

  lazy val ourSettings = Seq[Project.Setting[_]](
    organization := "com.nem",
    scalaVersion := Dependencies.V.thisScala,
    sourceDirectory in IntegrationTest <<= baseDirectory / "integrationtest",
    unmanagedSourceDirectories in IntegrationTest <+= baseDirectory / "sharedtest",
    unmanagedSourceDirectories in Test <+= baseDirectory / "sharedtest",
    crossScalaVersions := Seq(Dependencies.V.thisScala, Dependencies.V.newerScala),
    scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
    resolvers ++= Dependencies.resolutionRepos,
    scalaSource in SharedTest <<= baseDirectory / "sharedtest",
    javaSource in SharedTest <<= baseDirectory / "sharedtest",
    scalaSource in IntegrationTest <<= baseDirectory / "integrationtest",
    javaSource in IntegrationTest <<= baseDirectory / "integrationtest",
    parallelExecution in SharedTest := false,
    parallelExecution in IntegrationTest := false,
    logLevel in compile := Level.Error
  )
  lazy val ourBuildInfoSettings = Seq(
    sourceGenerators in Compile <+= buildInfo,
    sourceGenerators in Test <+= buildInfo,
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "custom_test_play_example"
  )

  lazy val ourScalaxbSettings = Seq(
    packageName in scalaxb in Compile := "com.nem.scalaxb",
    wrapContents in scalaxb in Compile := Seq(""),
    sourceGenerators in Compile <+= scalaxb in Compile
  )
  lazy val allSettings = Defaults.defaultSettings ++
    inConfig(IntegrationTest)(Defaults.testSettings) ++
    inConfig(SharedTest)(Defaults.testSettings) ++ ourSettings ++
    buildInfoSettings ++ ourBuildInfoSettings ++
    scalaxbSettings ++ ourScalaxbSettings
}


