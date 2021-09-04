package leetcode;

public class NumIslands {
    boolean [][] visited;
    int x, y;
    public int numIslands(char[][] grid) {
        x = grid.length;
        if (x == 0 ) return 0;
        y = grid[0].length;

        visited = new boolean[x][y];
        int numOfIslands = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=x || j >=y|| visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
