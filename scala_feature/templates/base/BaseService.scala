package <%= packageName %>

import spray.routing.SimpleRoutingApp
import spray.routing.Route
import spray.http.MediaTypes
import spray.httpx.Json4sSupport
import org.json4s.DefaultFormats
import org.json4s.Formats
import <%= packageName %>.<%= camelizedSingularName %>.model.<%= featureName %>
import scala.concurrent.ExecutionContext.Implicits.global
import spray.routing.Directive
import <%= packageName %>.<%= camelizedSingularName %>.dao.<%= featureName %>Dao
import scala.concurrent.{ ExecutionContext, Future }
import spray.routing._
import Directives._
import spray.routing.authentication.{ Authentication, ContextAuthenticator }
import scala.concurrent.Await
import java.sql.Timestamp
import utils.CORSSupport

object Json4sProtocol extends Json4sSupport {
  implicit def json4sFormats: Formats = DefaultFormats
}

trait BaseService extends SimpleRoutingApp with CORSSupport {

  def getJson(route: Route) = get {
    respondWithMediaType(MediaTypes.`application/json`) {
      route
    }
  }

  def postJson(route: Route) = post {
    respondWithMediaType(MediaTypes.`application/json`) {
      route
    }
  }

  def putJson(route: Route) = put {
    respondWithMediaType(MediaTypes.`application/json`) {
      route
    }
  }

  def deleteJson(route: Route) = delete {
    respondWithMediaType(MediaTypes.`application/json`) {
      route
    }
  }

}