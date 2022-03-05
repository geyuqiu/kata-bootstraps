package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortJumbledTest {
  SortJumbled sortJumbled = new SortJumbled();

  private static Stream<Arguments>
  sortJumbledTest() {
    return Stream.of(
      Arguments.of(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38}, new int[]{338,38,991}),
      Arguments.of(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123}, new int[]{123,456,789})
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  sortJumbledTest(int[] mapping, int[] nums, int[] expected){
    assertThat(sortJumbled.sortJumbled(mapping, nums))
      .isEqualTo(expected);
  }
}
