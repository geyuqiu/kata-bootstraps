package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class MaxHappyGroupsTest {
	MaxHappyGroups maxHappyGroups = new MaxHappyGroups();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	countNicePairs() {
		return Stream.of(
			Arguments.of(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}, 4),
			Arguments.of(3, new int[]{9, 3, 6, 12}, 4), // everyone gets fresh batches
			Arguments.of(3, new int[]{1, 2, 3, 4, 5, 6}, 4),
			Arguments.of(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6, 2, 1}, 5)
		);
	}
	@ParameterizedTest
	@MethodSource void
	countNicePairs(int batchSize, int[] groups, int expected) {
		int actual = maxHappyGroups.maxHappyGroupsBruteForce(batchSize, groups);

		assertThat(actual).isEqualTo(expected);
	}
}
