package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author YUQIU
 */
class AreSentencesSimilarTest {
	AreSentencesSimilar areSentencesSimilar = new AreSentencesSimilar();

	@SuppressWarnings("unused")
	private static Stream<Arguments>
	areSentencesSimilar() {
		return Stream.of(
			Arguments.of("Eating right now", "Eating", true),
			Arguments.of("Luky", "Lucccky", false),
			Arguments.of("My name is Haley", "My Haley", true),
			Arguments.of("of", "A lot of words", false),
			Arguments.of("Lucccky", "Lucccky", true),
			Arguments.of("", "Lucccky", true),
			Arguments.of("Lucccky", "", true),
			Arguments.of("XQE y dxCLvd VkM Wa J", "XQE Wa J", true),
			Arguments.of("jiRNY fW rN S bpL r T S nl vndZkF om oUm ilsf pvyNJObW F Uj QNJUek",
				"jiRNY fW rN S bpL r T Uj QNJUek", true),
			Arguments.of("TjZ ScAi m xz PNWaKigqqY p IyJ B rok",
				"TjZ ScAi m LlbJhCf gL u m R pZpiH mSk a og xz PNWaKigqqY p IyJ B rok", true)
		);
	}
	@ParameterizedTest
	@MethodSource
	void
	areSentencesSimilar(String sentence1, String sentence2, boolean expected) {
		boolean actual = areSentencesSimilar.areSentencesSimilar(sentence1, sentence2);

		assertThat(actual).isEqualTo(expected);
	}
}
