package $package$.impl.app

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import $package$.entity.$service;format="Camel"$Event
import $package$.entity.$service;format="Camel"$Command
import $package$.entity.$service;format="Camel"$State

object $service;format="Camel"$SerializerRegistry extends JsonSerializerRegistry {
  override def serializers = Vector(
    JsonSerializer[$service;format="Camel"$State]
  ) ++
  $service;format="Camel"$Event.serializers ++
  $service;format="Camel"$Command.serializers
}
