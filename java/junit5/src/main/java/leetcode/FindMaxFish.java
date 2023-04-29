package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindMaxFish {
  boolean [][] visited;
  List<Integer> fishOfWaters = new ArrayList<>();
  int x, y;
  public int findMaxFish(int[][] grid) {
    x = grid.length;
    y = grid[0].length;

    visited = new boolean[x][y];
    int numOfWaters = 0;

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        visited[i][j] = false;
      }
    }

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (!visited[i][j] && grid[i][j] > 0) {
          fishOfWaters.add(0);

          dfs(grid, i, j);
          numOfWaters++;
        }
      }
    }

    int max = 0;
    for (int fish: fishOfWaters) {
      max = Math.max(max, fish);
    }

    return max;
  }

  private void dfs(int[][] grid, int i, int j) {
    if (i<0 || j<0 || i>=x || j >=y|| visited[i][j] || grid[i][j] == 0) return;
    visited[i][j] = true;
    if (grid[i][j] > 0) {
      fishOfWaters.set(fishOfWaters.size()-1, fishOfWaters.get(fishOfWaters.size()-1) + grid[i][j]);
    }
    dfs(grid, i+1, j);
    dfs(grid, i-1, j);
    dfs(grid, i, j+1);
    dfs(grid, i, j-1);
  }
}
