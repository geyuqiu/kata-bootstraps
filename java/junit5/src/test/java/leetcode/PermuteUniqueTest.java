package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class PermuteUniqueTest {

	PermuteUnique permuteUnique = new PermuteUnique();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	permuteUnique() {
		return Stream.of(
//			Arguments.of(new int[]{1, 1, 2},
//				List.of(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1))
//			),
			Arguments.of(new int[]{1, 2, 3},
				List.of(
					List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
					List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)
				)
			)
		);
	}

	@ParameterizedTest
	@MethodSource
	void
	permuteUnique(int[] nums, List<List<Integer>> expected) {
		List<List<Integer>> actual = permuteUnique.permuteUnique(nums);

		assertThat(actual).isEqualTo(expected);
	}
}
