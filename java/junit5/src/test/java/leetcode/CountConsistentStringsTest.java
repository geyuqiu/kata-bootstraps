package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class CountConsistentStringsTest {
	CountConsistentStrings countConsistentStrings = new CountConsistentStrings();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	countConsistentStrings() {
		return Stream.of(
			Arguments.of("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}, 2),
			Arguments.of("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}, 7),
			Arguments.of("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}, 4)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	countConsistentStrings(String allowed, String[] words, int expected) {
		int actual = countConsistentStrings.countConsistentStrings(allowed, words);

		assertThat(actual).isEqualTo(expected);
	}
}
