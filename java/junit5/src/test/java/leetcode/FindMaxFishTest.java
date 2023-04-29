package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FindMaxFishTest {

  FindMaxFish findMaxFish = new FindMaxFish();

  private static Stream<Arguments>
  findMaxFish() {
    return Stream.of(
      Arguments.of(
        new int[][]{
          {0, 2, 1, 0},
          {4, 0, 0, 3},
          {1, 0, 0, 4},
          {0, 3, 2, 0}
        }, 7
      ),
      Arguments.of(
        new int[][]{
          {1, 0, 0, 0},
          {0, 0, 0, 0},
          {0, 0, 0, 0},
          {0, 0, 0, 1}
        }, 1
      )
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  findMaxFish(int[][] grid, int expected){
    assertThat(findMaxFish.findMaxFish(grid))
      .isEqualTo(expected);
  }
}
