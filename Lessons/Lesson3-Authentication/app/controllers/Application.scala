package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action { request =>
  Ok ("Hello world!" + request)
  }

  def name(name:String) = Action {
    Ok (name)
  }

  def google = Action {
    Redirect("https://www.google.com")
  }

  def add(number1: Int, number2: Int) = Action {
    Ok( (number1 + number2).toString())
  }
}