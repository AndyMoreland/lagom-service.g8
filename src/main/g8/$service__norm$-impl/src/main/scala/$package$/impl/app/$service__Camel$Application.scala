package $package$.impl.app

import akka.persistence.jdbc.config.SlickConfiguration
import akka.persistence.jdbc.util.{SlickDatabase, SlickDriver}
import com.auth0.jwt.algorithms.Algorithm
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.lightbend.lagom.scaladsl.client.ConfigurationServiceLocatorComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.WriteSideCassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.persistence.slick.ReadSideSlickPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import com.typesafe.config.Config
import money.haven.crypto.Secrets
import money.haven.utils.security.JwtSignatureComponents
import money.haven.utils.security.{JWTUtils, JwtSignatureComponents}
import com.lightbend.lagom.scaladsl.client.ConfigurationServiceLocatorComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import $package$.api.$service;format="Camel"$Service
import $package$.impl.$service;format="Camel"$ServiceImpl
import $package$.impl.entity.$service;format="Camel"$Entity
import play.api.Environment
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.mvc.EssentialFilter
import play.filters.cors.CORSComponents
import play.api.{Environment, LoggerConfigurator}
import play.api.db.{DBComponents, HikariCPComponents}
import slick.jdbc.{JdbcBackend, JdbcProfile}

import scala.concurrent.ExecutionContext

trait $service;format="Camel"$Components 
  extends LagomServerComponents 
  with ReadSideSlickPersistenceComponents
  with HikariCPComponents
  with DBComponents
  with WriteSideCassandraPersistenceComponents
  with JwtSignatureComponents {

  implicit def executionContext: ExecutionContext

  def environment: Environment

  lazy val rsConfig: Config = actorSystem.settings.config.getConfig("lagom.persistence.read-side.jdbc")
  lazy val slickConfig: SlickConfiguration = new SlickConfiguration(rsConfig)
  override lazy val db: JdbcBackend.Database = SlickDatabase.forConfig(rsConfig, slickConfig)
  override lazy val profile: JdbcProfile = SlickDriver.forDriverName(rsConfig)

  override lazy val jsonSerializerRegistry = $service;format="Camel"$SerializerRegistry
}

abstract class $service;format="Camel"$Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents
    with $service;format="Camel"$Components
    with CORSComponents {
  override val httpFilters: Seq[EssentialFilter] = Seq(corsFilter)

  persistentEntityRegistry.register(wire[$service;format="Camel"$Entity])

  override lazy val lagomServer: LagomServer = serverFor[$service;format="Camel"$Service](wire[$service;format="Camel"$ServiceImpl])
}

class $service;format="Camel"$ApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) =
    new $service;format="Camel"$Application(context) with ConfigurationServiceLocatorComponents with LagomKafkaComponents {
      override def jwtSigningAlgorithm: Algorithm = JWTUtils.createAlgorithm(Secrets.jwtSigningSecret)
  }

  override def loadDevMode(context: LagomApplicationContext) = {
    val environment = context.playContext.environment
    LoggerConfigurator(environment.classLoader).forEach {
      _.configure(environment)
    }

    new $service;format="Camel"$Application(context) with LagomDevModeComponents with LagomKafkaComponents {
      override def jwtSigningAlgorithm: Algorithm = JWTUtils.createAlgorithm(Secrets.jwtSigningSecret)
    }
  }

  override def describeServices = List(
    readDescriptor[api.$service;format="Camel"$Service]
  )
}
