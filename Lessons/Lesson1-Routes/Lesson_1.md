= Lesson 1: Getting up and running

In this lesson you'll want to open the project in IntelliJ:

* Import Project
* Navigate to Freezing-dangerzone/Lessons/Lesson1-Routes and import it
* Choose "Import project from existing model" and choose SBT
* Click Next
* Choose the "Use auto-import" box
* Click Finish

IntelliJ will work for a while during the project import, this is normal. If you see a message about VCS route you can choose cancel... this isn't important right now.

Ok, now that the project is up, right click on the "conf" folder and choose "New" -> "File". You'll want to name this file "routes".

In routes, add this line:

GET / @controllers.Application.index

Next, go to Lesson1-Routes [root] in your project explorer, right click and add a new directory called "app".

Right click on "app" and add new File, specifying the file name as "controllers/Application.scala"

Open Application.scala and paste the following code in:

package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok("Hello world!")
  }
}

Next, 'cd' to the Lesson1-Routes directory and run the following: sbt run

You should see output like the following:

--- (Running the application, auto-reloading is enabled) ---

[info] p.a.l.c.ActorSystemProvider - Starting application default Akka system: application
[info] p.c.s.NettyServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000

(Server started, use Ctrl+D to stop and go back to the console...)


The line "Listening for HTTP on /0:0:0:0:0:0:0:0:9000" means that the web server is listening at localhost:9000, so let's go ahead and pull it up!

While "Hello World!" is a great start, we can improve this by adding some basic user interactivity.

Inside your Application class, add the following Action:

  def username(name:String) = Action {
    Ok ("Hello " + name + "!")
  }

Now the contents of Application.scala should look like the following:

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

In your browser visit localhost:9000/username/<your name here> and see a personalized greeting!