package leetcode;

/**
 * @author YUQIU
 * max # of jumps when frog is changing lane
 * no obstacles on second lane, then done
 * there is always a way to get to the goal: normally moving (if greedy, but do we get a validi solution going greedy ?)
 	* first east, then north / south, for greedy, if doing dfs / greedy, if meeting dead end then go back to start?
 * side jump: jump over 1 rock on the 2 lane (moving 2 fields)
 */
public class MinSideJumps { // https://leetcode.com/contest/weekly-contest-236/problems/minimum-sideway-jumps,
	int[][] costs; // dp
	public int minSideJumps(int[] obstacles) { // time: O(3n), space: O(3n)
		int n = obstacles.length;
		if (n < 3) return 0;

		boolean obstacleMetOnSecondLane = false;
		for (int i = 1; i < n - 1; i++) {
			if (obstacles[i] == 2) obstacleMetOnSecondLane = true;
		}
		if (!obstacleMetOnSecondLane) return 0;

		costs = new int[n][3]; // dp
		markObstacles(obstacles);
		initializeCosts(n);
		markQuestionable();

		print2DimCost(costs);

		fillCosts();
		int r = getMin(costs);
		return r;
	}

	private void initializeCosts(int n) {
		// costs at 0. and n-1. are obvious
		costs[0][0] = 1;
		costs[0][1] = 0;
		costs[0][2] = 1;
		costs[n-1][0] = 0;
		costs[n-1][1] = 0;
		costs[n-1][2] = 0;
	}

	private void fillCosts() {
		// go through 2 dim array cost and see west /north / south
		// if (on second lane: i==1 && cost[i][j] == MAX) cost[i][j] = min(w, n, s)
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < 3; j++) {

			}
		}
	}

	private int getMin(int[][] costs) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (costs[i][j] > 0 && costs[i][j] < min) min = costs[i][j];
			}
		}
		return min;
	}

	private void markQuestionable() {
		for (int i = 1; i < costs.length - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (costs[i][j] != -1) costs[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void markObstacles(int[] obstacles) {
		for (int i = 1; i < obstacles.length-1; i++) {
			if (obstacles[i] == 0) {
				continue;
			}
			int laneIndex = obstacles[i] - 1;
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
}
