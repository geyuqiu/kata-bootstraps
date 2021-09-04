package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindFarmlandTest {

    FindFarmland findFarmland = new FindFarmland();

    @SuppressWarnings("unused")
    private static Stream<Arguments>
    findFarmland() {
        return Stream.of(
                Arguments.of(new int[][]{{1,0,0},{0,1,1},{0,1,1}}, new int[][] {{0,0,0,0},{1,1,2,2}}),
                Arguments.of(new int[][]{{1,1},{1,1}}, new int[][] {{0,0,1,1}}),
                Arguments.of(new int[][]{{0}}, new int[][]{})
        );
    }
    @ParameterizedTest
    @MethodSource void
    findFarmland(int[][] land, int[][] expected) {
        int[][] actual = findFarmland.findFarmland(land);

        assertThat(actual).isEqualTo(expected);
    }
}