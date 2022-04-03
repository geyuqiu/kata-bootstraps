package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertTimeTest {

  ConvertTime convertTime = new ConvertTime();

  @SuppressWarnings("unused")
  private static Stream<Arguments>
  convertTime() {
    return Stream.of(
      Arguments.of("02:30", "04:25", 6)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  convertTime(String current, String correct, int expected) {
    int actual = convertTime.convertTime(current, correct);

    assertThat(actual).isEqualTo(expected);
  }
}
