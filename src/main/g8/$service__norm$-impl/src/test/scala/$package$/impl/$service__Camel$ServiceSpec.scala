package $package$.impl

import com.lightbend.lagom.scaladsl.api.AdditionalConfiguration
import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.{ServiceTest, TestTopicComponents}
import $package$.api
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}
import $package$.impl.app.$service;format="Camel"$Application
import money.haven.utils.security.{ClientSecurity, JWTUtils, SimpleJwtAlgorithm}
import money.haven.utils.JdbcTestHelper

class $service;format="Camel"$ServiceSpec extends AsyncWordSpec with Matchers with BeforeAndAfterAll with ScalaFutures {

  lazy private val server = ServiceTest.startServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
    new $service;format="Camel"$Application(ctx) with LocalServiceLocator with SimpleJwtAlgorithm with TestTopicComponents {
      override def additionalConfiguration: AdditionalConfiguration = {
        super.additionalConfiguration ++ JdbcTestHelper.testServiceConfig("$service;format="Camel"$Spec")
      }
    }
  }

  val client: api.$service;format="Camel"$Service = server.serviceClient.implement[api.$service;format="Camel"$Service]

  override def afterAll: Unit = server.stop()

  override def beforeAll: Unit = server

  "The $service;format="Camel"$ Service" should {
    "" in {
      for {
        response <- client.apiCall.invoke("hello")
      } yield {
        1 should ===(1)
      }
    }
  }
}

