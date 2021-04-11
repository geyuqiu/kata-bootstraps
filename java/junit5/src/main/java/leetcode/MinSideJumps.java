package leetcode;

/**
 * @author YUQIU
 * max # of jumps when frog is changing lane
 * no obstacles on second lane, then done
 * there is always a way to get to the goal
 */
public class MinSideJumps { // https://leetcode.com/contest/weekly-contest-236/problems/minimum-sideway-jumps,
	public int minSideJumps(int[] obstacles) { // time: O(3n), space: O(3n)
		int n = obstacles.length;
		if (n < 3) return 0;

		boolean obstacleMetOnSecondLane = false;
		for (int i = 1; i < n - 1; i++) {
			if (obstacles[i] == 2) obstacleMetOnSecondLane = true;
		}
		if (!obstacleMetOnSecondLane) return 0;

		int r = 0;
		int[][] visited = new int[n][3]; // 0: unvisited, 1: visisted, 2: obstacle
		int[][] costs = new int[n][3]; // dp

		markObstacles(obstacles, visited, costs);

		// costs at 0. and n. are obvious
		costs[0][0] = 1;
		costs[0][1] = 0;
		costs[0][2] = 1;
		costs[n-1][0] = 0;
		costs[n-1][1] = 0;
		costs[n-1][2] = 0;

		markAsPaths(visited, costs);

		print2DimArray(visited);
		System.out.println();
		print2DimCost(costs);

		return r;
	}

	private void markAsPaths(int[][] visited, int[][] costs) {
		for (int i = 1; i < visited.length - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (visited[i][j] != 2) costs[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void markObstacles(int[] obstacles, int[][] visited, int[][] costs) {
		for (int i = 1; i < obstacles.length-1; i++) {
			if (obstacles[i] == 0) {
				continue;
			}
			int laneIndex = obstacles[i] - 1;

			visited[i][laneIndex] = 2; // 2 as obstacle
			costs[i][laneIndex] = -1;
			// -1 as obstacle, displayed as X
			// MAX displayed as ?
		}
	}

	void print2DimCost(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				String value = "";
				if (a[i][j] == Integer.MAX_VALUE) value = "?";
				else if (a[i][j] == -1) value = "X";
				else value = a[i][j] + "";
				System.out.print(value);
			}
			System.out.println();
		}
	}

	void print2DimArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
