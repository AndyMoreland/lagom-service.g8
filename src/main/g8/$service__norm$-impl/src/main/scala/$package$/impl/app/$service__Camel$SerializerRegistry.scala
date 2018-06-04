package $package$.impl.app

import money.haven.utils.serialization.HavenSerializerRegistry
import com.lightbend.lagom.scaladsl.playjson.{JsonSerializer, JsonSerializerRegistry}
import com.lightbend.lagom.scaladsl.playjson.{JsonMigration, JsonSerializer}

object $service;format="Camel"$SerializerRegistry extends HavenSerializerRegistry {
  override def serializers: Vector[JsonSerializer[_]] = Vector(DONE_SERIALIZER)

  override def migrations: Map[String, JsonMigration] = Map[String, JsonMigration]()
}
