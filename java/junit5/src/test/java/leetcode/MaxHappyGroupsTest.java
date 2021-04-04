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
	maxHappyGroupsBruteForce() {
		return Stream.of(
			Arguments.of(3, new int[]{1, 2, 3}, 2),
			Arguments.of(3, new int[]{1, 2, 3, 4, 5, 6}, 4),
			Arguments.of(3, new int[]{9, 3, 6, 12}, 4), // everyone gets fresh batches
			Arguments.of(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}, 4),
			Arguments.of(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6, 2, 1}, 5),
			Arguments.of(6, new int[]{369205928, 981877451, 947462486, 899465743, 737778942, 573732515, 520226542, 824581298, 571789442, 251943251, 70139785, 778962318, 43379662, 90924712, 142825931, 182207697, 178834435, 978165687}, 10)
		);
	}
	@ParameterizedTest
	@MethodSource void
	maxHappyGroupsBruteForce(int batchSize, int[] groups, int expected) {
		int actual = maxHappyGroups.maxHappyGroupsBruteForce(batchSize, groups);

		assertThat(actual).isEqualTo(expected);
	}
}
