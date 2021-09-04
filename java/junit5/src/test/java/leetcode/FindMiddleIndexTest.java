package leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindMiddleIndexTest {
    FindMiddleIndex findMiddleIndex = new FindMiddleIndex();

    @SuppressWarnings("unused")
    private static Stream<Arguments>
    findMiddleIndex() {
        return Stream.of(
                Arguments.of(new int[]{2,3,-1,8,4}, 3),
                Arguments.of(new int[]{1,-1,4}, 2),
                Arguments.of(new int[]{2,5}, -1),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{4,0}, 0)
        );
    }
    @ParameterizedTest
    @MethodSource
    void
    findMiddleIndex(int[] nums, int expected) {
        int actual = findMiddleIndex.findMiddleIndex(nums);

        assertThat(actual).isEqualTo(expected);
    }
}