package tdd;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzbuzzTest {
  Fizzbuzz fizzbuzz = new Fizzbuzz();

  private static Stream<Arguments>
  fizzbuzzTest() {
    return Stream.of(
      Arguments.of(1, "1"),
      Arguments.of(3, "fizz"),
      Arguments.of(5, "buzz"),
      Arguments.of(15, "fizz buzz")
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  fizzbuzzTest(int nums, String expected){
    assertThat(fizzbuzz.fizzbuzz(nums))
      .isEqualTo(expected);
  }
}
