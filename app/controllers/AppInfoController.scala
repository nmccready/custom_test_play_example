package controllers

import play.api.mvc._

object AppInfoController extends Controller {
  def version() = Action {
    Ok(custom_test_play_example.BuildInfo.version)
  }
}