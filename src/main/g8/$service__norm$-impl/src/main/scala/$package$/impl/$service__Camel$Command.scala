package $package$.impl

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}

sealed trait $service;format="Camel"$Command

object $service;format="Camel"$DummyCommand {
  implicit val format: Format[$service;format="Camel"$DummyCommand] = Json.format
}

case class $service;format="Camel"$DummyCommand(wow: String)
  extends $service;format="Camel"$Command
    with ReplyType[akka.Done]
