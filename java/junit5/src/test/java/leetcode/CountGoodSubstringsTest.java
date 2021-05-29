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
class CountGoodSubstringsTest {

	CountGoodSubstrings countGoodSubstrings = new CountGoodSubstrings();
	@Test
	void countGoodSubstrings() {
	}

	private static Stream<Arguments>
	countNicePairs() {
		return Stream.of(
			Arguments.of("xyzzaz", 1),
			Arguments.of("aababcabc", 4)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	countNicePairs(String s, int expected) {
		int actual = countGoodSubstrings.countGoodSubstrings(s);

		assertThat(actual).isEqualTo(expected);
	}
}
