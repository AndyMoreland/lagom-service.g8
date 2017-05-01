package $package$.impl

import java.time.LocalDateTime

import play.api.libs.json.{Format, Json}

sealed trait $service;format="Camel"$Event

case class $service;format="Camel"$CreatedEvent(created: LocalDateTime)
  extends $service;format="Camel"$Event

object $service;format="Camel"$CreatedEvent {
  implicit val format: Format[$service;format="Camel"$CreatedEvent] = Json.format
}
