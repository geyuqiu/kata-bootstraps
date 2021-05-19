package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YUQIU
 */
public class SubsetXORSum {
	public int subsetXORSum(int[] nums) {
		int sum = 0;
		List<List<Integer>> result = subsets(nums);

		System.out.println(result);

		for (List<Integer> l : result) {
			int xor = l.get(0);
			for (int i = 1; i < l.size(); i++) {
				xor ^= l.get(i);
			}
			sum += xor;
		}

		return sum;
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

			if (copy.size() > 0) result.add(copy);
		} else {
			backtracking(nums, pos + 1);
			subset.add(nums[pos]);
			backtracking(nums, pos + 1);
			subset.remove(subset.size() - 1);
		}
	}
}
