package codility;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestPositiveIntNotOccuringInArrayTest {
  SmallestPositiveIntNotOccuringInArray smallestPositiveIntNotOccuringInArray =
    new SmallestPositiveIntNotOccuringInArray();

  private static Stream<Arguments> smallestPositiveIntNotOccuringInArray() {
    return Stream.of(
      Arguments.of(new int[]{1,3,6,4,1,2}, 5),
      Arguments.of(new int[]{-1,-3}, 1),
      Arguments.of(new int[]{1,2,3}, 4)
    );
  }

  @ParameterizedTest
  @MethodSource
  void smallestPositiveIntNotOccuringInArray(int[] A, int expected) {
    assertThat(smallestPositiveIntNotOccuringInArray.smallestPositiveIntNotOccuringInArray(A))
      .isEqualTo(expected);
  }
}
