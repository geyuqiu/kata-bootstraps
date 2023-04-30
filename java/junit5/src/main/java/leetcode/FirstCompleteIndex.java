package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex {
  boolean[][] visited;
  Map<Integer, Coord> map = new HashMap<>();
  int x,y;
  int firstCompleteIndexBruteForce(int[] arr, int[][] mat) { // O(A * n^2)
    x = mat.length;
    y = mat[0].length;
    visited = new boolean[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        visited[i][j] = false;
        map.put(mat[i][j], new Coord(i,j));
      }
    }

    for (int i = 0; i < arr.length; i++) {
      Coord coord = (Coord) map.get(arr[i]);
      visited[coord.x][coord.y] = true;
      if (oneRowOrColumnFilled()) return i;
    }
    return -1;
  }

  private boolean oneRowOrColumnFilled() { // O(n^2)
    if (oneRowFilled() || oneColumnFilled()) return true;
    return false;
  }

  private boolean oneColumnFilled() {
    for (int j = 0; j < y; j++) {
      boolean temp = true;
      for (int i = 0; i < x; i++) {
        if (!visited[i][j])  {
          temp = false;
          continue;
        }
      }
      if (temp) {
        return true;
      }
    }
    return false;
  }

  private boolean oneRowFilled() {
    for (int i = 0; i < x; i++) {
      boolean temp = true;
      for (int j = 0; j < y; j++) {
        if (!visited[i][j])  {
          temp = false;
          break;
        }
      }
      if (temp) {
        return true;
      }
    }
    return false;
  }

  class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
