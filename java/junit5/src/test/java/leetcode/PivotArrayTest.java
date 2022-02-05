package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PivotArrayTest {

  PivotArray pivotArray = new PivotArray();

  private static Stream<Arguments>
  pivotArray() {
    return Stream.of(
      Arguments.of(new int[]{9,12,5,10,14,3,10}, 10, new int[]{9,5,3,10,10,12,14})
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  pivotArray(int[] nums, int pivot, int[] expected){
    assertThat(pivotArray.pivotArray(nums, pivot))
      .isEqualTo(expected);
  }
}
