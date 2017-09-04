package $package$.impl.entity

import java.time.LocalDateTime

import com.lightbend.lagom.scaladsl.playjson.JsonSerializer
import play.api.libs.json.Json

sealed trait $service;format="Camel"$Event

case class $service;format="Camel"$CreatedEvent(created: LocalDateTime)
  extends $service;format="Camel"$Event

object $service;format="Camel"$CreatedEvent {
  val serializers = Vector(
    JsonSerializer(Json.format[$service;format="Camel"$CreatedEvent])
  )
}
