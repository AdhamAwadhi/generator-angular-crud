package com.lot

import scala.concurrent.duration.DurationInt
import com.lot.order.model.OrderJsonProtocol
import com.lot.user.service.UserService
import com.typesafe.scalalogging.LazyLogging
import akka.actor.Actor
import akka.util.Timeout
import spray.routing.HttpService
import utils.Configuration
import utils.PersistenceModule
import com.lot.StaticService
import utils.CORSSupport
import com.typesafe.config.ConfigFactory
import com.lot.order.service.OrderService

class RoutesActor(modules: Configuration with PersistenceModule) extends Actor with 
  HttpService with StaticService with CORSSupport with LazyLogging {

  def actorRefFactory = context

  implicit val timeout = Timeout(5.seconds)
  
  // Add your application routes below
  def receive = runRoute(staticRoute)
}



 