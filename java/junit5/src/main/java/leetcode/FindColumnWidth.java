package leetcode;

public class FindColumnWidth {
  int[] findColumnWidth(int[][] grid) {
    int[] result = new int[grid[0].length];
    for (int j = 0; j < grid[0].length; j++) {
      int max = 0;
      for (int i = 0; i < grid.length; i++) {
        int width = String.valueOf(grid[i][j]).length();
        System.out.println(width);
        if (width > max) {
          max = width;
          result[j] = max;
        }
      }
    }
    return result;
  }
}
