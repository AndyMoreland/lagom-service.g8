package $package$.api

import money.haven.utils.services.HavenInternalService
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import play.api.libs.json.{Format, Json}

trait $service;format="Camel"$Service extends HavenInternalService {
  def apiCall: ServiceCall[String, akka.Done]

  override def descriptor: Descriptor = {
    import Service._
    baseDescriptor("$service;format="camel"$").addCalls(
      pathCall("/api/", apiCall)
    )
  }
}
