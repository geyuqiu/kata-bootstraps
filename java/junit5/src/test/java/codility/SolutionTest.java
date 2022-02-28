package codility;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

  Solution solution = new Solution();

  private static Stream<Arguments>
  solutionTest() {
    return Stream.of(
      Arguments.of(1,3, new int[]{0,1,2,-2,3},new int[]{0,1,4,1,0}, 2),
      Arguments.of(2,4, new int[]{4,0,1,-2},new int[]{-4,4,3,0}, 1)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  solutionTest(int inner, int outer, int[] points_x, int[] points_y, int expected){
    assertThat(solution.solution(inner, outer, points_x, points_y))
      .isEqualTo(expected);
  }
}
