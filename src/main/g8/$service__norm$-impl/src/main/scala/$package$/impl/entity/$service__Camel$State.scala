package $package$.impl.entity

import com.lightbend.lagom.scaladsl.playjson.JsonSerializer
import java.time.LocalDateTime
import money.haven.utils.JsonFormats
import play.api.libs.json.{Format, Json}

case class $service;format="Camel"$State(id: String, created: LocalDateTime)

object $service;format="Camel"$State {
  val serializers = Vector(
    JsonSerializer(Json.format[$service;format="Camel"$State])
  )
}
