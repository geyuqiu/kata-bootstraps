package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ColorTheArrayTest {

    ColorTheArray colorTheArray = new ColorTheArray();

    @SuppressWarnings("unused")
    private static Stream<Arguments>
    colorTheArray() {
        return Stream.of(
                Arguments.of(4,new int[][]{{0,2},{1,2},{3,1},{1,1},{2,1}}, new int[]{0,1,1,0,2}),
                Arguments.of(1,new int[][]{{0,100000}}, new int[]{0})
        );
    }
    @ParameterizedTest
    @MethodSource
    void
    colorTheArray(int n, int[][] queries, int[] expected) {
        int[] actual = colorTheArray.colorTheArray(n, queries);

        assertThat(actual).isEqualTo(expected);
    }

}
