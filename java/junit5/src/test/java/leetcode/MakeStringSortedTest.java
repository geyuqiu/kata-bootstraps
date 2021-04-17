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
class MakeStringSortedTest {
	@SuppressWarnings("unused")
	private static Stream<Arguments> makeStringSorted() {
		return Stream.of(
			Arguments.of("cba", 5),
			Arguments.of("aabaa", 2),
			Arguments.of("cdbea", 63),
			Arguments.of("leetcodeleetcodeleetcode", 982157772)
		);
	}

	@ParameterizedTest
	@MethodSource
	void makeStringSorted(String s, int expected) {
		MakeStringSorted makeStringSorted = new MakeStringSorted();

		int actual = makeStringSorted.makeStringSortedBruteforce(s);

		assertThat(actual).isEqualTo(expected);
	}
}
