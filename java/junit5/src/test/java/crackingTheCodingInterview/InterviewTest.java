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
			Arguments.of(new int[]{2,1,3}, 2, 3),
			Arguments.of(new int[]{0,4,3,-1}, 2, 2),
			Arguments.of(new int[]{2,1,4}, 3, 0)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	test(int[] A, int S, int expected) {
		int actual = interview.solution(A, S);

		assertThat(actual).isEqualTo(expected);
	}
}
