package $package$.impl

import money.haven.utils.services.{HavenServiceImpl, ServiceAuthConfiguration, SplitServiceParent}
import com.lightbend.lagom.scaladsl.persistence.ReadSide
import $package$.api._
import money.haven.utils.entities.history.HavenEntityRegistry
import money.haven.utils.readside.SlickReadSideConfig
import money.haven.utils.services.{HavenServiceImpl, ServiceAuthConfiguration}
import money.haven.utils.tasks.HavenTaskRegistry
import money.haven.utils.time.HavenClock
import scala.concurrent.Future
import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

import scala.concurrent.ExecutionContext

class $service;format="Camel"$ServiceImpl(
  config: SlickReadSideConfig,
  readSide: ReadSide,
  override val havenEntityRegistry: HavenEntityRegistry,
  override val havenTaskRegistry: HavenTaskRegistry,
  override val serviceAuthConfiguration: ServiceAuthConfiguration,
  registry: PersistentEntityRegistry,
)(
  override implicit val ec: ExecutionContext,
  implicit val clock: HavenClock
) extends $service;format="Camel"$Service 
  with HavenServiceImpl {

  override def apiCall: ServiceCall[String, Done] = 
    _ => Future.successful(akka.Done)

}
