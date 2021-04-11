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
class MinSideJumpsTest {


	@SuppressWarnings("unused")
	private static Stream<Arguments> minSideJumps() {
		return Stream.of(
			Arguments.of(new int[]{0, 1, 2, 3, 0}, 2),
			Arguments.of(new int[]{0, 1, 1, 3, 3, 0}, 0),
			Arguments.of(new int[]{0, 2, 1, 0, 3, 0}, 2),
			Arguments.of(new int[]{0, 2, 3, 0, 3, 0}, 1)
		);
	}

	@ParameterizedTest
	@MethodSource
	void minSideJumps(int[] obstacles, int expected) {
		MinSideJumps minSideJumps = new MinSideJumps();

		int actual = minSideJumps.minSideJumps(obstacles);

		assertThat(actual).isEqualTo(expected);
	}
}
