package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaximumCandiesTest {
  MaximumCandies maximumCandies = new MaximumCandies();

  @SuppressWarnings("unused")
  private static Stream<Arguments>
  maximumCandies() {
    return Stream.of(
      Arguments.of(new int[]{4,7,5}, 4, 3),
      Arguments.of(new int[]{5,8,6}, 3, 5)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  maximumCandies(int[] candies, long k, int expected) {
    int actual = maximumCandies.maximumCandies(candies, k);

    assertThat(actual).isEqualTo(expected);
  }
}
