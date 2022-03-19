package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaximumSubsequenceCountTest {
  MaximumSubsequenceCount maximumSubsequenceCount = new MaximumSubsequenceCount();

  private static Stream<Arguments>
  getAncestorsTest() {
    return Stream.of(
      Arguments.of("zigfj", "ju", 1),
      Arguments.of("iuvgbmteyivbfwuospxmmgzagfa", "ti", 3),
      Arguments.of("abdcdbc", "ac", 4),
      Arguments.of("aabb", "ab", 6),
      Arguments.of("wotvvnrsqqjvgwcwayhldexdblawlmuocruhwojjbmnagepcvzumxoyoiqvihbbvgaqekmkotbkevnwjbbcfcqnozecnvpuczxbazchpshanqzzndrezfjtmweutdycvymjwnjfelbwrjfujjuzlbtbcrsymrzqgaozviecsvenpffolgxmhmtmzimgecqznhbjvdgbrlbrjvsahjuaivxueygwmwbaetpnnstuyjfeksnzigjnnhrpxxjeamprvlfmykwqrpbgybryacndkqtgnyzosxxlqdukyedtnthpoovqhlakxwwdnmjatekbenarzztahswhmblrxrvggiejclnzgyfbeujiuhjnawalagmzlqaevltutlftskbkmzivqaulwuoprnytnprdbsvhopxkyumhykortnamplmkdvwzunouhovadilrcguqxqyowkeveukakfacfjmezpaccushssotvtyxhlc",
        "um", 224)
    );
  }
  @ParameterizedTest
  @MethodSource
  void
  getAncestorsTest(String text, String pattern, int expected) {
    assertThat(maximumSubsequenceCount.maximumSubsequenceCount(text, pattern))
      .isEqualTo(expected);
  }
}
