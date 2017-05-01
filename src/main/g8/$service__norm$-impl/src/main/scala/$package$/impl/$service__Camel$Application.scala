package $package$.impl

import com.lightbend.lagom.scaladsl.client.ConfigurationServiceLocatorComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import $package$.api
import play.api.Environment
import play.api.libs.ws.ahc.AhcWSComponents

import scala.concurrent.ExecutionContext

trait $service;format="Camel"$Components extends LagomServerComponents with CassandraPersistenceComponents {
  implicit def executionContext: ExecutionContext

  def environment: Environment

  override lazy val jsonSerializerRegistry = $service;format="Camel"$SerializerRegistry

  persistentEntityRegistry.register(wire[$service;format="Camel"$Entity])
}

abstract class $service;format="Camel"$Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents
    with CassandraPersistenceComponents
    with $service;format="Camel"$Components {

  override lazy val lagomServer: LagomServer = LagomServer.forServices(
    bindService[api.$service;format="Camel"$Service].to(wire[$service;format="Camel"$ServiceImpl])
  )
}

class $service;format="Camel"$ApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) =
    new $service;format="Camel"$Application(context) with ConfigurationServiceLocatorComponents

  override def loadDevMode(context: LagomApplicationContext) =
    new $service;format="Camel"$Application(context) with LagomDevModeComponents

  override def describeServices = List(
    readDescriptor[api.$service;format="Camel"$Service]
  )
}
