resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "sonatype-public" at "https://oss.sonatype.org/content/groups/public",
  "repo.codahale.com" at "http://repo.codahale.com")


addSbtPlugin("play" % "sbt-plugin" % "2.1-09142012")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0-TYPESAFE")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "0.7.3")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.2.0")