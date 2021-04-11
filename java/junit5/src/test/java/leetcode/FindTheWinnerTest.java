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
class FindTheWinnerTest {

	FindTheWinner findTheWinner = new FindTheWinner();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	findTheWinner() {
		return Stream.of(
			Arguments.of(5, 2, 3),
			Arguments.of(6, 5, 1)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	findTheWinner(int n, int k, int expected) {
		int actual = findTheWinner.findTheWinner(n, k);

		assertThat(actual).isEqualTo(expected);
	}
}
