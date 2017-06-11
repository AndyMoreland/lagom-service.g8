package $package$.impl.app

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
object $service;format="Camel"$SerializerRegistry extends JsonSerializerRegistry {
  override def serializers = Vector(
    JsonSerializer[$service;format="Camel"$State],
    JsonSerializer[$service;format="Camel"$CreatedEvent],
    JsonSerializer[$service;format="Camel"$DummyCommand]
  )
}
