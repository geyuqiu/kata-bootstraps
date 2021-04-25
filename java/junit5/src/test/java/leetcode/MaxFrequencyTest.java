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
class MaxFrequencyTest {

	private static Stream<Arguments> maxFrequency() {
		return Stream.of(
			Arguments.of(new int[]{1,2,4}, 5, 3),
			Arguments.of(new int[]{1,4,8,13}, 5, 2),
			Arguments.of(new int[]{3,9,6}, 2, 1)
			,
			Arguments.of(new int[]{3,3,4}, 2, 3),
			Arguments.of(new int[]{4,3,3}, 2, 3),
			Arguments.of(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056, 73)
		);
	}

	@ParameterizedTest
	@MethodSource
	void maxFrequency(int[] nums, int k, int expected) {
		MaxFrequency maxFrequency = new MaxFrequency();

		int actual = maxFrequency.maxFrequency(nums, k);

		assertThat(actual).isEqualTo(expected);
	}
}
