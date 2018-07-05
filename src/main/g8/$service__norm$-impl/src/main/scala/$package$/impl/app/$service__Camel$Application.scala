package $package$.impl.app

import com.auth0.jwt.algorithms.Algorithm
import com.lightbend.lagom.scaladsl.api.Service
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import money.haven.crypto.secrets.Secrets
import $package$.api.$service;format="Camel"$Service
import $package$.impl.$service;format="Camel"$ServiceImpl
import money.haven.utils.entities.history.{HavenReadSidePersistenceComponents, HavenWriteSidePersistenceComponents}
import money.haven.utils.security.JWTUtils
import money.haven.utils.serialization.HavenSerializerRegistry
import money.haven.utils.services.application.HavenApplication
import money.haven.utils.services.application.HavenProdComponents

abstract class $service;format="Camel"$Application(context: LagomApplicationContext)
    extends HavenApplication(context)
    with HavenReadSidePersistenceComponents
    with HavenWriteSidePersistenceComponents {

  override lazy val jsonSerializerRegistry: HavenSerializerRegistry = $service;format="Camel"$SerializerRegistry
  lazy implicit val alg: Algorithm = jwtSigningAlgorithm

  override lazy val lagomServer: LagomServer =
    serverFor[$service;format="Camel"$Service](wire[$service;format="Camel"$ServiceImpl])
}

class $service;format="Camel"$ApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) =
    new $service;format="Camel"$Application(context) with HavenProdComponents with LagomKafkaComponents {
      override def jwtSigningAlgorithm: Algorithm = JWTUtils.createAlgorithm(Secrets.jwtSigningSecret)
    }

  override def loadDevMode(context: LagomApplicationContext) =
    new $service;format="Camel"$Application(context) with LagomDevModeComponents with LagomKafkaComponents {
      override def jwtSigningAlgorithm: Algorithm = JWTUtils.createAlgorithm(Secrets.jwtSigningSecret)
    }

  override def describeService = Some(readDescriptor[$service;format="Camel"$Service])
}
