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
class MaxDistanceTest {
	MaxDistance maxDistance = new MaxDistance();
	@SuppressWarnings("unused")
	private static Stream<Arguments>
	maxDistance() {
		return Stream.of(
			Arguments.of(new int[]{55, 30, 5, 4, 2},new int[]{100, 20, 10, 10, 5}, 2),
			Arguments.of(new int[]{2, 2, 2},new int[]{10, 10, 1}, 1),
			Arguments.of(new int[]{30, 29, 19, 5},new int[]{25, 25, 25, 25, 25}, 2),
			Arguments.of(new int[]{5,4},new int[]{3,2}, 0)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	maxDistance(int[] nums1, int[] nums2, int expected) {
		int actual = maxDistance.maxDistance(nums1, nums2);

		assertThat(actual).isEqualTo(expected);
	}
}
