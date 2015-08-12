package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
  Ok ("Hello world!")
  }

  def username(name:String) = Action {
    Ok ("Hello " + name + "!")
  }
}