package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstCompleteIndexTest {

  FirstCompleteIndex firstCompleteIndex = new FirstCompleteIndex();

  private static Stream<Arguments>
  findMaxFish() {
    return Stream.of(
      Arguments.of(
        new int[]{2,8,7,4,1,3,5,6,9},
        new int[][]{
          {3,2,5},
          {1,4,6},
          {8,7,9},
        }, 3
      )
      ,
      Arguments.of(
        new int[]{1,3,4,2},
        new int[][]{
          {1, 4},
          {2, 3}
        }, 2
      )
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  findMaxFish(int[] arr, int[][] mat, int expected){
    assertThat(firstCompleteIndex.firstCompleteIndex(arr, mat))
      .isEqualTo(expected);
  }
}
