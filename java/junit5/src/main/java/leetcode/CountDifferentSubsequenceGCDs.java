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
		max = Math.min(max, 100000);

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
		List<Integer> gcds = new ArrayList<>();
		int counter = 0;
		for (int n: nums) {
			if (n % gcd == 0) {
				counter++;
				gcds.add(n);
			}
		}

		if (counter < 2) return false;
		for (int n : gcds) {
			gcds.set(gcds.indexOf((Integer)n), n/gcd);
		}
		if (gcd(new ArrayList<Integer>(gcds)) == 1) return true; // if you divide each number in the subsequence by x, then the gcd of the resulting numbers should be 1.
		return false;
	}

	int gcd(List<Integer> nums) { // O(n * log(s)), s being the smallest number of nums
		int result = nums.get(0); // associativity: gcd(a,b,c,d) = gcd(gcd(gcd(a,b),c),d)
		for (int i = 1; i < nums.size(); i++) {
			result = gcd(result, nums.get(i));

			if (result == 1) return 1;
		}
		return result;
	}

	int gcd(int a, int b) { // O(log(a+b))
		if (a % b == 0) return b;
		else return gcd(b, a % b);
	}
}
