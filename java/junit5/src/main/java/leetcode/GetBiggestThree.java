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
		findRombus(grid, m, n);

		Collections.sort(r);
		LinkedHashMap<Integer, Boolean> hm = new LinkedHashMap<>();
		for (int i: r) {
			if (!hm.containsKey(i)) {
				hm.put(i, true);
			}
		}

		int[] res = new int[hm.size()];
		int index = 0;

		for (Map.Entry<Integer, Boolean> entry: hm.entrySet()) {
			res[index] = entry.getKey();
			index++;
		}
		return res;
	}

	private void findRombus(int[][] grid, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				r.add(grid[i][j]);
			}
		}
	}
}
