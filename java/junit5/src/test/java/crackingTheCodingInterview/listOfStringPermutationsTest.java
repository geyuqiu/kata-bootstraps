package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YUQIU
 */
class listOfStringPermutationsTest {

	@Test
	void permutation() {
		List<String> permutations = new listOfStringPermutations().permutation("str");

		assertEquals(List.of("str", "srt", "tsr", "trs", "rts", "rst"), permutations);
	}
}
