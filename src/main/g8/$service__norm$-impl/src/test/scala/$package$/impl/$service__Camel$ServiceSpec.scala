package $package$.impl

import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import $package$.api
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}

class $service;format="Camel"$ServiceSpec extends AsyncWordSpec with Matchers with BeforeAndAfterAll with ScalaFutures {

  lazy private val server = ServiceTest.startServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
    new app.$service;format="Camel"$Application(ctx) with LocalServiceLocator
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

