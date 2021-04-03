package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class CountNicePairsTest {

	@SuppressWarnings("unused")
	private static Stream<Arguments> countNicePairs() {
		return Stream.of(
			Arguments.of(new int[]{42, 11, 1, 97}, 2),
			Arguments.of(new int[]{13, 10, 35, 24, 76}, 4)
		);
	}

	@ParameterizedTest
	@MethodSource
	void countNicePairs(int[] nums, int expected) {
		CountNicePairs countNicePairs = new CountNicePairs();

		int actual = countNicePairs.countNicePairs(nums);

		assertThat(actual).isEqualTo(expected);
	}
}
