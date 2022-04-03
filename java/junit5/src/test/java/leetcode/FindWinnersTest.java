package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FindWinnersTest {

  FindWinners findWinners = new FindWinners();

  @SuppressWarnings("unused")
  private static Stream<Arguments>
  findWinners() {
    List<List<Integer>> arrayLists = new ArrayList<>();
    arrayLists.add(List.of(1,2,10));
    arrayLists.add(List.of(4,5, 7,8));

    return Stream.of(
      Arguments.of(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}, arrayLists)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  findWinners(int[][] matches, List<List<Integer>> expected) {
    List<List<Integer>> actual = findWinners.findWinners(matches);

    assertThat(actual).isEqualTo(expected);
  }
}
