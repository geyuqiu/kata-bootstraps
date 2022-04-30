package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAverageDifferenceTest {

  MinimumAverageDifference minimumAverageDifference = new MinimumAverageDifference();
  @Test
  void minimumAverageDifference() {
    assertEquals(3, minimumAverageDifference.minimumAverageDifference(new int[]{2,5,3,9,5,3}));
  }
}
