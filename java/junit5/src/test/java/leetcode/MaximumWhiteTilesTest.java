package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumWhiteTilesTest {
  MaximumWhiteTiles maximumWhiteTiles = new MaximumWhiteTiles();

  @Test
  void maximumWhiteTiles() {
//    assertEquals(9, maximumWhiteTiles.maximumWhiteTiles(
//      new int[][]{{1,5},{10,11},{12,18},{20,25},{30,32}}, 10
//    ));
    assertEquals(2, maximumWhiteTiles.maximumWhiteTiles(
      new int[][]{{10,11},{1,1}}, 2
    ));
  }
}
