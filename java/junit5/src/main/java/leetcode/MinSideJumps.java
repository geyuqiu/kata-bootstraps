package leetcode;

/**
 * @author YUQIU
 */
public class MinSideJumps { // https://leetcode.com/contest/weekly-contest-236/problems/minimum-sideway-jumps, number of jumps when frog is changing lane
	public int minSideJumps(int[] obstacles) { // O(n)
		int n = obstacles.length;
		if (n < 3) return 0;

		int r = 0;
		int[][] visited = new int[n][3]; // 0: unvisited, 1: visisted, 2: obstacle
		for (int i = 1; i < n-1; i++) {
			int laneIndex = obstacles[i] - 1;
			if (laneIndex < 0) continue;
			visited[i][laneIndex] = 2;
		}
		print2DimArray(visited);

		return r;
	}

	void print2DimArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
