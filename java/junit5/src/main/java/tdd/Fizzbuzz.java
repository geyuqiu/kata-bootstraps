package tdd;

public class Fizzbuzz {
  String fizzbuzz(int num) {
    if (num % 15 == 0) return "fizz buzz";
    if (num % 3 == 0) return "fizz";
    if (num % 5 == 0) return "buzz";
    return String.valueOf(num);
  }
}
