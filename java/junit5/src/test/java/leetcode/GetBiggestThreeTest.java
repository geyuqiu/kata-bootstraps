package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class GetBiggestThreeTest {

	GetBiggestThree getBiggestThree = new GetBiggestThree();

	private static Stream<Arguments>
	getBiggestThree() {
		return Stream.of(
			Arguments.of(new int[][]{{7, 7, 7}}, new int[]{7}),
			Arguments.of(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}, new int[]{20, 9, 8}),
			Arguments.of(
				new int[][]{{3, 4, 5, 1, 3},{3, 3, 4, 2, 3},{20, 30, 200, 40, 10},{1, 5, 5, 4, 1},{4, 3, 2, 2, 5}},
				new int[]{228, 216, 211}
			)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	getBiggestThree(int[][] grid, int[] expected) {
		int[] actual = getBiggestThree.getBiggestThree(grid);

		assertArrayEquals(expected, actual);
	}
}
