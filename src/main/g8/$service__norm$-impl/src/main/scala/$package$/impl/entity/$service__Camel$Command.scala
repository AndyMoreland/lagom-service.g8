package $package$.impl.entity

import com.lightbend.lagom.scaladsl.playjson.JsonSerializer
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}
import akka.Done

sealed trait $service;format="Camel"$Command

case class $service;format="Camel"$DummyCommand(wow: String)
  extends $service;format="Camel"$Command
    with ReplyType[Done]

object $service;format="Camel"$Command {
  val serializers = Vector(
    JsonSerializer(Json.format[$service;format="Camel"$DummyCommand])
  )
}

