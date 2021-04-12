package leetcode;

/**
 * @author YUQIU
 * max # of jumps when frog is changing lane
 * no obstacles on second lane, then done
 * every point max 1 obstacle
 * there is always a way to get to the goal: normally moving (if greedy, but do we get a validi solution going greedy ?)
 	* first east, then north / south, for greedy, if doing dfs / greedy, if meeting dead end then go back to start?
 * side jump: jump over 1 rock on the 2 lane (moving 2 fields)
 */
public class MinSideJumps { // https://leetcode.com/contest/weekly-contest-236/problems/minimum-sideway-jumps,
	int[][] costs; // dp
	int INT_MAX = Integer.MAX_VALUE - 1000;
	int OBSTACLE = Integer.MAX_VALUE - 100000;
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
		System.out.println();

		fillCosts();
		print2DimCost(costs);
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
		for (int i = 1; i < costs.length - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (costs[i][j] != OBSTACLE) {
					calcLocalMax(i, j);
					if (costs[i][j] != INT_MAX) propogateLocalMax(i, j);
				}
			}
		}
	}

	private void propogateLocalMax(int i, int j) {
		if (!isObstacle(right(i, j))) costs[i + 1][j] = Math.min(right(i, j), costs[i][j]);
		if (j == 0) {
			if (!isObstacle(up(i, j))) costs[i][j + 1] = Math.min(up(i, j), costs[i][j] + 1);
			if (!isObstacle(upJump(i, j)) && isObstacle(up(i,j))) costs[i][j + 2] = Math.min(upJump(i, j), costs[i][j]+1);
		} else if (j == 2) {
			if (!isObstacle(down(i, j))) costs[i][j - 1] = Math.min(down(i, j), costs[i][j] + 1);
			if (!isObstacle(downJump(i, j)) && isObstacle(down(i, j))) costs[i][j - 2] = Math.min(downJump(i, j), costs[i][j]+1);
		} else {
			if(!isObstacle(up(i, j))) costs[i][j+1] = Math.min(up(i, j), costs[i][j] + 1);
			if(!isObstacle(down(i, j))) costs[i][j-1] = Math.min(down(i, j), costs[i][j] + 1);
		}
	}

	private void calcLocalMax(int i, int j) { // if (on second lane: i==1 && cost[i][j] != OBSTACLE) cost[i][j] = min(w, n, s)
		if (j == 0) {
			costs[i][j] = Math.min(left(i, j), up(i, j) + 1); // only north, but think about jumping if north field is an obstacle...
			if (isObstacle(up(i, j))) {
				costs[i][j] = Math.min(costs[i][j], upJump(i, j) + 1);
			}
		} else if (j == 2) {
			costs[i][j] = Math.min(left(i, j), down(i, j) + 1);
			if (isObstacle(down(i, j))) {
				costs[i][j] = Math.min(costs[i][j], downJump(i, j) + 1); // only south, think about jumping ...
			}
		} else {
			costs[i][j] = Math.min(Math.min(left(i, j), up(i, j) + 1), down(i, j) + 1);
		}
	}

	private int downJump(int i, int j) {
		return costs[i][j - 2];
	}

	private int upJump(int i, int j) {
		return costs[i][j + 2];
	}

	private int right(int i, int j) {
		return costs[i + 1][j];
	}

	private int down(int i, int j) {
		return costs[i][j - 1];
	}

	private int up(int i, int j) {
		return costs[i][j + 1];
	}

	private int left(int i, int j) {
		return costs[i - 1][j];
	}

	private boolean isObstacle(int value) {
		return value == OBSTACLE;
	}

	private int getMin(int[][] costs) {
		int min = INT_MAX;
		int i = costs.length - 2;
		for (int j = 0; j < 3; j++) {
			if (costs[i][j] > 0 && costs[i][j] < min) min = costs[i][j];
		}
		return min;
	}

	private void markQuestionable() {
		for (int i = 1; i < costs.length - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (costs[i][j] != OBSTACLE) costs[i][j] = INT_MAX;
			}
		}
	}

	private void markObstacles(int[] obstacles) {
		for (int i = 1; i < obstacles.length-1; i++) {
			if (obstacles[i] == 0) {
				continue;
			}
			int laneIndex = obstacles[i] - 1;
			costs[i][laneIndex] = OBSTACLE;
			// OBSTACLE as obstacle, displayed as X
			// MAX displayed as ?
		}
	}

	void print2DimCost(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				String value = "";
				if (a[i][j] == INT_MAX) value = "?";
				else if (a[i][j] == OBSTACLE) value = "X";
				else value = a[i][j] + "";
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
