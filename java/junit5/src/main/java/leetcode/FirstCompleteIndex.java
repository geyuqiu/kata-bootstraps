package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstCompleteIndex {
  Map<Integer, Coord> map = new HashMap<>();
  int[] row;
  int[] column;
  int x,y;
  int firstCompleteIndex(int[] arr, int[][] mat) { // O(A)
    x = mat.length;
    y = mat[0].length;
    row = new int[x];
    column = new int[y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        map.put(mat[i][j], new Coord(i,j));
      }
    }

    for (int i = 0; i < arr.length; i++) {
      Coord coord = (Coord) map.get(arr[i]);
      row[coord.x]++;
      column[coord.y]++;

      if(row[coord.x] == y || column[coord.y] == x) {
        return i;
      }
    }
    return -1;
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
