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
			Arguments.of(new String[]{"test1a", "test2", "test1b", "test1c", "test3"},
				new String[]{"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"},
				33),
			Arguments.of(new String[]{"codility1", "codility3", "codility2", "codility4b", "codility4a"},
				new String[]{"Wrong answer", "OK", "OK", "Time limit exceeded", "OK"},
				50)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	test(String[] T, String[] R, int expected) {
		int actual = interview.solution(T,R);

		assertThat(actual).isEqualTo(expected);
	}
}
