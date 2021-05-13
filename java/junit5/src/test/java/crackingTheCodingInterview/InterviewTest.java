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
			Arguments.of(new int[]{1,2,3,4,5,4, 1,2,3,4}, 5),
			Arguments.of(new int[]{7, 3, 7, 3, 1, 3, 4, 1}, 5),
			Arguments.of(new int[]{2, 1, 1, 3, 2, 1, 1, 3}, 3),
			Arguments.of(new int[]{7, 5, 2, 7, 2, 7, 4, 7}, 6),
			Arguments.of(new int[]{7,2,3}, 3),
			Arguments.of(new int[]{1,2,3,4,5,4}, 5)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	test(int[] A, int expected) {
		int actual = interview.solution(A);

		assertThat(actual).isEqualTo(expected);
	}
}
