import sbt._

object App {
  val appName = "custom_test_play_example"
  val appVersion = "0.0.1"
}

object ApplicationBuild extends Build {

  import App._
  import Settings._

  val main = PlayProject(appName, appVersion, appDependencies, settings = allSettings)
    .configs(IntegrationTest)
}