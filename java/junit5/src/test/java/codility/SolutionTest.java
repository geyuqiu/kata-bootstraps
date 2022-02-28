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
      Arguments.of(new int[]{1,2}, 0)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  solutionTest(int[] nums, String expected){
    assertThat(solution.solution(nums))
      .isEqualTo(expected);
  }
}
