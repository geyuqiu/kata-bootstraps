package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestWordCountTest {
  LargestWordCount largestWordCount = new LargestWordCount();
  @Test
  void largestWordCount() {
    assertEquals("abfedA", largestWordCount.largestWordCount(
      new String[]{"Hello","Hello","Hello","Hello"},
      new String[]{"abFedc","abfEdc","abfeDc","abfedA"}
    ));
  }
}
