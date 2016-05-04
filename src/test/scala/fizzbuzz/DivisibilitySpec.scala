package fizzbuzz

import org.scalatest.{Matchers, WordSpec}

class DivisibilitySpec extends WordSpec with Matchers  with DivisibleBy5 with DivisibleBy3{

  //TODO: 0.Test the methods that check divisibility in Fizz and Buzz
  //Note: you may have to refactor the actors
  "Divisibility trait" should {
    "determine if number is divisible by 5" in {
      isDivisibleByThree(3) === true
      isDivisibleByThree(5) === false
    }

    "determine if number is divisible by 3" in {
      isDivisibleByFive(5) === true
      isDivisibleByFive(3) === false
    }
  }
}

