package model

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class TestActor extends Actor with TestService {

  def actorRefFactory = context

  def receive = runRoute(TestRoute)

}

trait TestService extends HttpService
{

  val TestRoute =
    path("") {
      complete {
        <html><body>
          <p>
            Test
          </p>
        </body></html>
      }
    }
}