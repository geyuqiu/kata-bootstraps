package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinIncrementsTest {

    MinIncrements minIncrements = new MinIncrements();

    @SuppressWarnings("unused")
    private static Stream<Arguments>
    minIncrements() {
        return Stream.of(
                Arguments.of(15,new int[]{764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761}, 15735),
                Arguments.of(7,new int[]{1,5,2,2,3,3,1}, 6),
                Arguments.of(3,new int[]{5,3,3}, 0)
        );
    }
    @ParameterizedTest
    @MethodSource
    void
    minIncrements(int n, int[] cost, int expected) {
        int actual = minIncrements.minIncrements(n, cost);

        assertThat(actual).isEqualTo(expected);
    }
}
