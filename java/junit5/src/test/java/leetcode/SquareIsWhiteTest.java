
package leetcode;

	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.Arguments;
	import org.junit.jupiter.params.provider.MethodSource;

	import java.util.stream.Stream;

	import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class SquareIsWhiteTest {

	@SuppressWarnings("unused")
	private static Stream<Arguments> squareIsWhite() {
		return Stream.of(
			Arguments.of("h3", true),
			Arguments.of("a1", false),
			Arguments.of("c7", false),
			Arguments.of("h8", false),
			Arguments.of("c2", true)
		);
	}
	@ParameterizedTest
	@MethodSource
	void squareIsWhite(String coordinates, boolean expected) {
		SquareIsWhite squareIsWhite = new SquareIsWhite();

		boolean actual = squareIsWhite.squareIsWhite(coordinates);

		assertThat(actual).isEqualTo(expected);
	}
}
