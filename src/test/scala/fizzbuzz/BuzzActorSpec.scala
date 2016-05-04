package fizzbuzz

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import akka.util.Timeout
import fizzbuzz.FizzBuzzMessages.{Reply, Request}
import org.scalatest.{Matchers, WordSpecLike}

import scala.util.Success
import scala.concurrent.duration._
import akka.pattern.ask

class BuzzActorSpec extends TestKit(ActorSystem("TestSystem"))
  with WordSpecLike
  with Matchers
  with StopSystemAfterAll
{
  //TODO: 2. test actor with telling syncronously
  "BuzzActor" should {
    "reply with 'Buzz' if number is divisible by 5" in {
      val actorRef = TestActorRef(new BuzzActor)
      implicit val timeout = Timeout(5 seconds)
      val request = Request(10, null, 1)

      val future = actorRef ? request
      val futureResult = future.value.get

      val expectedReply = Reply(Right("Buzz"), request)
      futureResult should be(Success(expectedReply))
    }

    "reply with original number if it is not divisible by 5" in {
      val actorRef = TestActorRef(new BuzzActor)
      implicit val timeout = Timeout(5 seconds)
      val request = Request(9, null, 1)

      val future = actorRef ? request
      val futureResult = future.value.get

      val expectedReply = Reply(Left(9), request)
      futureResult should be(Success(expectedReply))
    }
  }
}
