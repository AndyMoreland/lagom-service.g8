package $package$.impl

import scala.concurrent.Future
import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry
import $package$.api

import scala.concurrent.ExecutionContext

class $service;format="Camel"$ServiceImpl(registry: PersistentEntityRegistry)(implicit ec: ExecutionContext)
  extends api.$service;format="Camel"$Service {

  override def apiCall: ServiceCall[String, akka.Done] = ServiceCall { _ =>
    Future.successful(akka.Done)
  }

  private def refFor($service;format="camel"$Id: String) = {
    registry.refFor[$service;format="Camel"$Entity]($service;format="camel"$Id)
  }

}
