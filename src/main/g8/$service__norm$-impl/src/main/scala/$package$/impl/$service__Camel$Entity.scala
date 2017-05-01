package $package$.impl

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity
import java.time.LocalDateTime


class $service;format="Camel"$Entity extends PersistentEntity {
  override type Command = $service;format="Camel"$Command
  override type State = Option[$service;format="Camel"$State]
  override type Event = $service;format="Camel"$Event

  override def initialState: Option[$service;format="Camel"$State] = None

  override def behavior: Behavior = {
    case None => notCreated
    case Some(_) => created
  }

  private val created = {
    Actions().onCommand[$service;format="Camel"$DummyCommand, akka.Done] {
      case (command, ctx, state) =>
        val created = LocalDateTime.now
        ctx.thenPersist($service;format="Camel"$CreatedEvent(created))(_ => ctx.reply(akka.Done))
    }.onEvent {
      case (event, state) =>
        state
    }
  }

  private val notCreated = {
    Actions()
  }

}
