package $package$.impl.entity

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}
import akka.Done

sealed trait $service;format="Camel"$Command

case class $service;format="Camel"$DummyCommand(wow: String)
  extends $service;format="Camel"$Command
    with ReplyType[Done]

object $service;format="Camel"$Command {
  implicit val format: Format[$service;format="Camel"$DummyCommand] = Json.format
  implicit lazy val format: Format[$service;format="Camel"$Command] = Jsonx.sealedTrait($service;format="Camel"$Command)
}

