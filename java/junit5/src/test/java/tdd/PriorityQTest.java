package tdd;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityQTest {

  @Test
  void sortByDefault() {
  }

  PriorityQ priorityQ =
    new PriorityQ();

  private static Stream<Arguments> smallestPositiveIntNotOccuringInArray() {
    return Stream.of(
      Arguments.of(new int[]{3,1,6,4,1,2}, 6)
    );
  }

  @ParameterizedTest
  @MethodSource
  void smallestPositiveIntNotOccuringInArray(int[] A, int expected) {
    assertThat(priorityQ.getMax(A))
      .isEqualTo(expected);
  }
}
