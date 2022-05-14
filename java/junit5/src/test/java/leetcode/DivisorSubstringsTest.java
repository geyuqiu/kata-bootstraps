package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorSubstringsTest {
  DivisorSubstrings divisorSubstrings = new DivisorSubstrings();

  @Test
  void divisorSubstrings() {
    assertEquals(2, divisorSubstrings.divisorSubstrings(240, 2));
    assertEquals(2, divisorSubstrings.divisorSubstrings(430043, 2));
    assertEquals(2, divisorSubstrings.divisorSubstrings(303, 1));
    assertEquals(1, divisorSubstrings.divisorSubstrings(303, 2));
  }
}
