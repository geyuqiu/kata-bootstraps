package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YUQIU
 */
public class GetBiggestThree { // O(m*n)
	int[] res = new int[3];
	int[] getBiggestThree(int[][] grid) {
		findRombus(grid);
		Arrays.sort(res);

		return res;
	}

	private void findRombus(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {



			}
		}
	}
}
