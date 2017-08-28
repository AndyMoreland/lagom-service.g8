package $package$.impl.entity

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity
import java.time.LocalDateTime
import akka.Done

class $service;format="Camel"$Entity extends PersistentEntity {
  override type Command = $service;format="Camel"$Command
  override type State = Option[$service;format="Camel"$State]
  override type Event = $service;format="Camel"$Event

  override def initialState: Option[$service;format="Camel"$State] = None

  override def behavior: Behavior = {
    case None => notCreated
    case Some(_) => created
  }

  private val created = DSLBehavior.behavior[Actions] {
    case $service;format="Camel"$DummyCommand(something) {
        $service;format="Camel"$CreatedEvent(LocalDateTime.now) -> Done
    }.onEvent {
      case (event, state) => state
    }
  }

  private val notCreated = DSLBehavior.behavior[Actions]

}
