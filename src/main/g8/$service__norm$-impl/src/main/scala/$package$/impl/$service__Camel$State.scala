package $package$.impl

import java.time.LocalDateTime
import money.haven.utils.JsonFormats
import play.api.libs.json.{Format, Json}


object $service;format="Camel"$State {
  implicit val format: Format[$service;format="Camel"$State] = Json.format
}

case class $service;format="Camel"$State(id: String, created: LocalDateTime)
