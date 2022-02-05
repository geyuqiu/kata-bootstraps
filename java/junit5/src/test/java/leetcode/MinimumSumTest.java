package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MinimumSumTest {
  MinimumSum minimumSum = new MinimumSum();

  private static Stream<Arguments>
  minimumSum() {
    return Stream.of(
      Arguments.of(2932, 52)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  minimumSum(int num, int expected){
    assertThat(minimumSum.minimumSum(num)).
      isEqualTo(expected);
  }
}
