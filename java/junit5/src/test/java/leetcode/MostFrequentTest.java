package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MostFrequentTest {

  MostFrequent mostFrequent = new MostFrequent();

  private static Stream<Arguments>
  mostFrequentTest() {
    return Stream.of(
      Arguments.of(new int[]{1,100,200,1,100}, 1, 100),
      Arguments.of(new int[]{2,2,2,2,3}, 2, 2)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  mostFrequentTest(int[] nums, int key, int expected){
    assertThat(mostFrequent.mostFrequent(nums, key))
      .isEqualTo(expected);
  }
}
