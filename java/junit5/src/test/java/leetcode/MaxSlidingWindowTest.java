package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSlidingWindowTest {
    MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();

    @SuppressWarnings("unused")
    private static Stream<Arguments>
    get_max_of_every_sliding_window() {
        return Stream.of(
            Arguments.of(new int[]{1,3,-1,-3,5,3,6,7}, 3,  new int[]{3,3,5,5,6,7}),
            Arguments.of(new int[]{1}, 1,  new int[]{1}),
            Arguments.of(new int[]{1, -1}, 1,  new int[]{1, -1}),
            Arguments.of(new int[]{7,2,4}, 2,  new int[]{7, 4}),
            Arguments.of(new int[]{9, 11}, 2,  new int[]{11}),
            Arguments.of(new int[]{4, -2}, 2,  new int[]{4}),
            Arguments.of(new int[]{7, 4, 5, 6}, 3,  new int[]{7, 6}),
            Arguments.of(new int[]{7, 4, 5, 3}, 3,  new int[]{7, 5}),
            Arguments.of(new int[]{9,10,9,-7,-4,-8,2,-6}, 5,  new int[]{10,10,9,2})
        );
    }
    @ParameterizedTest
    @MethodSource void
    get_max_of_every_sliding_window(int [] numbers, int windowSize, int[] slidingWindowNumbers){
        assertThat(maxSlidingWindow.maxSlidingWindow(numbers, windowSize)).
            isEqualTo(slidingWindowNumbers);
    }
}
