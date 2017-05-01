package $package$.api

import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import play.api.libs.json.{Format, Json}

trait $service;format="Camel"$Service extends Service {
  def apiCall: ServiceCall[String, akka.Done]

  override def descriptor: Descriptor = {
    import Service._
    named("$service;format="camel"$").withCalls(
      pathCall("/api/", apiCall)
    )
  }
}
