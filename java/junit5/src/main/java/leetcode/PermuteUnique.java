package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YUQIU
 */
public class PermuteUnique { // https://leetcode.com/problems/permutations-ii/
	boolean[] chosen; // https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> permutation = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) { // time: O(n*n!), space: O(n)
		int n = nums.length;
		chosen = new boolean[n];
		for (int i = 0; i < n; i++) chosen[i] = false;

		backtracking(nums);

		return result;
	}

	void backtracking(int[] nums) {
		if (permutation.size() == nums.length) {
			List copy = new ArrayList<Integer>();
			copy.addAll(permutation);
			if (!result.contains(copy)) result.add(copy);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (chosen[i]) continue;
				chosen[i] = true;
				permutation.add(nums[i]);
				backtracking(nums);
				chosen[i] = false;
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}
