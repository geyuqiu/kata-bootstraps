package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author YUQIU
 */
public class CountDifferentSubsequenceGCDs { // https://leetcode.com/problems/number-of-different-subsequences-gcds/
	// 1 <= nums.length <= 105
	// 1 <= nums[i] <= 2 * 105
	int countDifferentSubsequenceGCDsBruteforce(int[] nums) { // time: O(2^n * n * log(n))

		Set<Integer> gcds = new HashSet<>();

		List<List<Integer>> subsets = subsets(nums);
		for (List<Integer> subset: subsets) {
			gcds.add(gcd(subset));
		}
		return gcds.size();
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

	List<List<Integer>> result = new ArrayList<>();
	List<Integer> subset = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) { // time: O(2^n), space O(n)
		int n = nums.length;

		backtracking(nums, 0);

		return result;
	}

	void backtracking(int[] nums, int pos) {
		if (pos == nums.length) {
			List copy = new ArrayList<Integer>();
			copy.addAll(subset);
			if (!result.contains(copy) && !copy.isEmpty()) result.add(copy);
		} else {
			backtracking(nums, pos + 1);
			subset.add(nums[pos]);
			backtracking(nums, pos + 1);
			subset.remove(subset.size() - 1);
		}
	}
}
