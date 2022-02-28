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
      Arguments.of(new String[]{"pim","pom"},
        new String[]{"999999999","777888999"},
        "88999",
        "pom"
      )
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  solutionTest(String[] A, String[] B, String P, String expected){
    assertThat(solution.solution(A, B, P))
      .isEqualTo(expected);
  }
}
