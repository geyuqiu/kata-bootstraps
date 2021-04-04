package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class CountDifferentSubsequenceGCDsTest {

	CountDifferentSubsequenceGCDs countDifferentSubsequenceGCDs = new CountDifferentSubsequenceGCDs();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	countDifferentSubsequenceGCDs() {
		return Stream.of(
			Arguments.of(new int[]{6, 10, 3}, 5),
			Arguments.of(new int[]{5, 15, 40, 5, 6}, 7)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	countDifferentSubsequenceGCDs(int[] nums, int expected) {
		int actual = countDifferentSubsequenceGCDs.countDifferentSubsequenceGCDsBruteforce(nums);

		assertThat(actual).isEqualTo(expected);
	}

}
