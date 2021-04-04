package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author YUQIU
 */
public class CountDifferentSubsequenceGCDs { // https://leetcode.com/problems/number-of-different-subsequences-gcds/
	// 1 <= nums.length <= 10^5
	// 1 <= nums[i] <= 2 * 10^5
	int countDifferentSubsequenceGCDs(int[] nums) { // time: O(2^n * n * log(n))

		Set<Integer> gcds = new HashSet<>();

		int max = 0;
		for (int n: nums) {
			max = Math.max(n, max);
			gcds.add(n);
		}
		max = Math.min(max, 10000);

		for (int i = 0; i < max; i++) { // 0 -> % 1,  max-1 -> % max,
			int gcd = i + 1;
			if (!gcds.contains(gcd)) {
				if (checkIfAtLeast2DivisableBy(gcd, nums)) {
					gcds.add(gcd);
				}
			}
		}

		return gcds.size();
	}

	private boolean checkIfAtLeast2DivisableBy(int gcd, int[] nums) {
		int counter = 0;
		for (int n: nums) {
			if (n % gcd == 0) counter++;
			if (counter > 1) return true;
		}
		return false;
	}
}
