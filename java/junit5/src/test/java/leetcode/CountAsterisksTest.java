package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAsterisksTest {
  CountAsterisks countAsterisks = new CountAsterisks();

  @Test
  void countAsterisks() {
    assertEquals(2, countAsterisks.countAsterisks("l|*e*et|c**o|*de|"));
  }
}
