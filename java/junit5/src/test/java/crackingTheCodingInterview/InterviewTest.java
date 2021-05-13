package crackingTheCodingInterview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class InterviewTest {
	Interview interview = new Interview();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	test() {
		return Stream.of(
			Arguments.of(19, true)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	test(int num, boolean expected) {
		boolean actual = interview.isHappy(num);

		assertThat(actual).isEqualTo(expected);
	}
}
