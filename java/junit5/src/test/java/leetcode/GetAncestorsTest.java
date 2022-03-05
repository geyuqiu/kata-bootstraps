package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GetAncestorsTest {
  GetAncestors getAncestors = new GetAncestors();

  private static Stream<Arguments>
  getAncestorsTest() {
    List<List<Integer>> arrayLists = new ArrayList<>();
    arrayLists.add(new ArrayList<>());
    arrayLists.add(new ArrayList<>());
    arrayLists.add(new ArrayList<>());
    arrayLists.add(List.of(0,1));
    arrayLists.add(List.of(0,  2));
    arrayLists.add(List.of(0,1,  3));
    arrayLists.add(List.of(0,1,2,3,4));
    arrayLists.add(List.of(0,1,2,3));
    return Stream.of(
      Arguments.of(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}},
        arrayLists
      )
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  getAncestorsTest(int n, int[][] edges, List<List<Integer>> expected) {
    assertThat(getAncestors.getAncestors(n, edges))
      .isEqualTo(expected);
  }
}
