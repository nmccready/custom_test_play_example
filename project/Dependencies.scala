import sbt._

object Dependencies {
  val gitHubDependencies: Array[ClasspathDep[ProjectReference]] =
    Array(RootProject(uri("")))

  val resolutionRepos = Seq(
    "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
    "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
  )

  val compileDeps = Seq(
    "com.github.scala-incubator.io" %% "scala-io-core" % V.scalax_io //scala-io-file is in play    
  )

  val testDeps = Seq(
    "com.github.scala-incubator.io" %% "scala-io-core" % V.scalax_io,
    "com.typesafe.akka" % "akka-testkit" % V.akka,
    "org.specs2" %% "specs2" % V.specs2
  )

  object V {
    val dispatch = "0.8.8"
    val specs2 = "1.12.3"
    val slf4j = "1.6.4"
    val akka = "2.0.2"
    
    val scalax_io = "0.4.0"
    val oldScala = "2.9.2"
    val thisScala = "2.9.2"
    val newerScala = "2.10.0"
    val sources = "sources"
  }

  def addScalaV(namespace: String, version: String): String = appendAll(namespace, "_", version)

  def appendAll(strings: String*) = {
    val sb = new StringBuilder()
    strings.foreach(s => sb.append(s))
    sb.toString
  }
}