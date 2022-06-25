package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWhiteTiles {
  int maximumWhiteTiles(int[][] tiles, int carpetLen) {
    int maxLength = -1;
    int start = tiles[0][0];
    List<Integer> starts = new ArrayList<>();
    starts.add(start);
    int end = tiles[0][1];

    for (int i = 1; i < tiles.length; i++) { // O(t)
      starts.add(tiles[i][0]);
      start = Math.min(start, tiles[i][0]);
      end = Math.max(end, tiles[i][1]);
    }
    boolean[] carpetIsWhite = new boolean[end+1];

    for (int i = 0; i < tiles.length; i++) { // O(t * max(tile-length))
      for (int j = tiles[i][0]; j <= tiles[i][1]; j++) {
        carpetIsWhite[j] = true;
      }
    }

    int counter;
    for (int i = 0; i < starts.size(); i++) { // O(t * max(tile-length))
      counter = 0;
      for (int j = starts.get(i); j <= end && j - starts.get(i) < carpetLen; j++) {
        if (carpetIsWhite[j]) {
          counter++;
        }
      }
      maxLength = Math.max(maxLength, counter);
    }

    return maxLength;
  }
}
