package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitCountTest {
  DigitCount digitCount = new DigitCount();

  @Test
  void digitCount() {
    boolean expected = digitCount.digitCount("1210");
    assertTrue(expected);
    expected = digitCount.digitCount("030");
    assertFalse(expected);

  }
}
