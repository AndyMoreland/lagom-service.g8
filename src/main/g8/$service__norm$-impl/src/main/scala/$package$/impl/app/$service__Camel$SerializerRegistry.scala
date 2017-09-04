package $package$.impl.app

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import $package$.impl.entity.$service;format="Camel"$Event
import $package$.impl.entity.$service;format="Camel"$Command
import $package$.impl.entity.$service;format="Camel"$State

object $service;format="Camel"$SerializerRegistry extends JsonSerializerRegistry {
  override def serializers = Vector(
    JsonSerializer(JsonSerializer.emptySingletonFormat(akka.Done))
  ) ++
  $service;format="Camel"$State.serializers ++
  $service;format="Camel"$Event.serializers ++
  $service;format="Camel"$Command.serializers
}
