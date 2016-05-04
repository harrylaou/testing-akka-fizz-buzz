package fizzbuzz

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, TestKit}
import akka.util.Timeout
import fizzbuzz.FizzBuzzMessages.{Reply, Request}
import org.scalatest.{Matchers, WordSpecLike}
import akka.pattern.ask

import scala.concurrent.Future
import scala.util.Success
import scala.concurrent.duration._

class CombinatorActorSpec extends TestKit(ActorSystem("TestSystem"))
  with WordSpecLike
  with Matchers
  with StopSystemAfterAll
{
  //TODO: 3. Test combinator actor synchronously
  "Combinator actor" should {
    "store the pending requests and increase sequence number" in {
      val actorRef = TestActorRef(new CombinatorActor)
      implicit val timeout = Timeout(5 seconds)
      val request = Request(9, null, 1)
      val expectedReply: Reply = Reply(Right("Fizz"), request)

//      actorRef.underlyingActor.pending =
      val future = actorRef ! 9
      actorRef.underlyingActor.pending.get(request).get === expectedReply
      actorRef.underlyingActor.seqNum === 1


    }

    "remove processed requests from pending" in {
      ???
    }
  }
}
