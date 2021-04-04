package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YUQIU
 */
public class Subsets { // https://leetcode.com/problems/subsets/solution/
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> subset = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) { // time: O(2^n), space O(n)
		int n = nums.length;

		dfs(nums, 0);

		return result;
	}

	void dfs(int[] nums, int pos) {
		if (pos == nums.length) {
			List copy = new ArrayList<Integer>();
			copy.addAll(subset);
			if (!result.contains(copy)) result.add(copy);
		} else {
			dfs(nums, pos + 1);
			subset.add(nums[pos]);
			dfs(nums, pos + 1);
			subset.remove(subset.size() - 1);
		}
	}
}
