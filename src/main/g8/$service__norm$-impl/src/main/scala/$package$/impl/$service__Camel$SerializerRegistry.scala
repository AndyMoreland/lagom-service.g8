package $package$.impl

import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
object $service;format="Camel"$SerializerRegistry extends JsonSerializerRegistry {
  override def serializers = Vector(
    JsonSerializer[$service;format="Camel"$State]
  )
}
