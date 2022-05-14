package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToSplitArrayTest {
  WaysToSplitArray waysToSplitArray = new WaysToSplitArray();

  @Test
  void waysToSplitArray() {
    assertEquals(2, waysToSplitArray.waysToSplitArray(new int[]{10,4,-8,7}));
    assertEquals(2, waysToSplitArray.waysToSplitArray(new int[]{2,3,1,0}));
  }
}
