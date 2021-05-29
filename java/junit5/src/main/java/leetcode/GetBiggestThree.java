package leetcode;

import java.util.*;

/**
 * @author YUQIU
 */
public class GetBiggestThree { // O(m*n)
	List<Integer> r = new ArrayList<>();
	int[] getBiggestThree(int[][] grid) { // each of the corners centered in a grid cell
		int m = grid.length;
		int n = grid[0].length;
		findDiameter1x1(grid, m, n);

		int[] diameters = new int[50]; // m, n <= 100
		int index = 0;
		for (int i = 1; i < 50; i++) {
			if (i % 2 == 1) {
				diameters[index] = i;
			}
		}
		if ( m >= 3 && n >= 3) {
			for (int i = 0; i < 50; i++) {
				int d = diameters[i];
				if (d <= m && d <= n) findDiameter(grid, m, n, d);
			}
		}

		Collections.sort(r, Collections.reverseOrder());
		LinkedHashMap<Integer, Boolean> hm = new LinkedHashMap<>();
		for (int i: r) {
			if (!hm.containsKey(i)) {
				hm.put(i, true);
			}
		}

		int len;
		if (hm.size() < 3)  len = hm.size();
		else len = 3;
		int[] res = new int[len];
		index = 0;

		for (Map.Entry<Integer, Boolean> entry: hm.entrySet()) {
			res[index] = entry.getKey();
			index++;
			if (index == 3) break;
		}
		return res;
	}

	private void findDiameter1x1(int[][] grid, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.add(grid[i][j]);
			}
		}
	}

	private void findDiameter(int[][] grid, int i, int m, int diameter) {
		int sum = 0;



		r.add(sum);
	}
}
