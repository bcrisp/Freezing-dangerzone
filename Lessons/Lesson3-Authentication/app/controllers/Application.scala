package controllers

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

  val userForm = Form(
    mapping(
      "username" -> text,
      "password" -> text
    )(LoginData.apply)(LoginData.unapply)
  )
  def login = Action {
    Ok(views.html.login(userForm))
  }

  def loginData = Action{ implicit request =>
    val loginInfo = userForm.bindFromRequest.get
    if(loginInfo.username == "admin" && loginInfo. password == "123")
    {
      Ok("you are logged in")
    }
    else
    {
      Ok("you are not logged in")
    }
  }
}
