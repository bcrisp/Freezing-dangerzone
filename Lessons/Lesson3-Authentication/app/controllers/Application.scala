package controllers

import models.Customer
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n.Messages.Implicits._

import play.api.Play.current

case class LoginData(username: String, password: String)

class Application extends Controller  {

  def index = Action {
  Ok ("Hello world!")
  }

  def username(name:String) = Action {
    Ok ("Hello " + name + "!")
  }

  def login = Action {

    val userForm = Form(
      mapping(
        "username" -> text,
        "password" -> text
      )(LoginData.apply)(LoginData.unapply)
    )

    Ok(views.html.login(userForm))
  }
}