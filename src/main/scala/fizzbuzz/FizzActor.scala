package fizzbuzz

import akka.actor.Actor
import fizzbuzz.FizzBuzzMessages.{Request, Reply}

class FizzActor extends Actor with DivisibleBy3{
  def receive = {
    case r @ Request(num, _, _) =>
      if(isDivisibleByThree(num))
        sender() ! Reply(Right("Fizz"), r)
      else
        sender() ! Reply(Left(num), r)
    case _ => sender() ! "unknown message type"
  }


}

trait DivisibleBy3 {
  def isDivisibleByThree (num: Int): Boolean = {
    num % 3 == 0
  }
}
