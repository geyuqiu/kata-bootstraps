package leetcode;

import java.util.*;

/**
 * @author YUQIU
 */
public class GetBiggestThree { // O(m*n)
	List<Integer> r = new ArrayList<>();

	int[] getBiggestThree(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		findDiameter1x1(grid, m, n);

		int index = 0;
		if (m >= 3 && n >= 3) {
			int[] diameters = new int[49]; // m, n <= 100
			for (int i = 3; i < 100; i += 2, index++) {
				diameters[index] = i;
			}
			for (int i = 0; i < 49; i++) {
				int d = diameters[i];
				if (d <= m && d <= n) findDiameter(grid, m, n, d);
			}
		}

		// todo: replace with max 3 items without duplicates
		Collections.sort(r, Collections.reverseOrder());
		LinkedHashMap<Integer, Boolean> hm = new LinkedHashMap<>();
		for (int i : r) {
			if (!hm.containsKey(i)) {
				hm.put(i, true);
			}
		}

		int len;
		if (hm.size() < 3) len = hm.size();
		else len = 3;
		int[] res = new int[len];
		index = 0;

		for (Map.Entry<Integer, Boolean> entry : hm.entrySet()) {
			res[index] = entry.getKey();
			index++;
			if (index == 3) break;
		}

		System.out.println(hm);
		return res;
	}

	private void findDiameter1x1(int[][] grid, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.add(grid[i][j]);
			}
		}
	}

	private void findDiameter(int[][] grid, int m, int n, int diameter) { // each of the corners centered in a grid cell, 7 = 7/2 + 1 + 7/2

		for (int i = m / 2; i <= m - 1 - m / 2; i++) { // grid[i][j] as the center of Rhombus
			for (int j = n / 2; j <= n - 1 - n / 2; j++) {
				int sum = 0;

				// similar to css margin: 1px 2px 3px 4px
				int topX = i - m / 2;
				int topY = j;
				int top = grid[topX][topY];

				int rightX = i;
				int rightY = j + n / 2;
				int right = grid[rightX][rightY];

				int bottomX = i + m / 2;
				int bottomY = j;
				int bottom = grid[bottomX][bottomY];

				int leftX = i;
				int leftY = j - n / 2;
				int left = grid[leftX][leftY];

				sum += bottom + top + right + left;

				sum += findBetween(grid, topX, topY, rightX, rightY, 1, 1);
				r.add(sum);
			}
		}

	}

	private int findBetween(int[][] grid, int startX, int startY, int stopX, int stopY, int incrementX, int incrementY) {
		int sum = 0;
		while (true) {
			startX += incrementX;
			startY += incrementY;
			if (startX == stopX && startY == stopY) return sum;
			sum += grid[startX][startY];
		}
	}
}
