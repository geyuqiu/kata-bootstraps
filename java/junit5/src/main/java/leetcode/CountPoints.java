package leetcode;

/**
 * @author YUQIU
 */
public class CountPoints { // https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
	int[] countPoints(int[][] points, int[][] queries) { // O(q * p)
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];
			int r = queries[i][2];

			int sum = 0;
			for (int j = 0; j < points.length; j++) {
				if (inCircle(x, y, r, points[j][0], points[j][1])) sum++;
			}
			res[i] = sum;
		}

		return res;
	}

	private boolean inCircle(int mx, int my, int r, int px, int py) { // Pythagoras: a^2 + b^2 = c^2
		return Math.pow(mx - px, 2) + Math.pow(my - py, 2) <= Math.pow(r, 2);
	}
}
