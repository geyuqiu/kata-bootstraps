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
class CanBeIncreasingTest {

	CanBeIncreasing canBeIncreasing = new CanBeIncreasing();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	canBeIncreasing() {
		return Stream.of(
			Arguments.of(new int[]{1, 2, 10, 5, 7}, true),
			Arguments.of(new int[]{2, 3, 1, 2}, false),
			Arguments.of(new int[]{1, 1, 1}, false),
			Arguments.of(new int[]{1, 2, 3}, true)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	canBeIncreasing(int[] nums, boolean expected) {
		boolean actual = canBeIncreasing.canBeIncreasing(nums);

		assertThat(actual).isEqualTo(expected);
	}
}
