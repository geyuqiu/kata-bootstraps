package leetcode;

/**
 * @author YUQIU
 */
public class MinOperations { // https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
	int minOperations(int[] nums) { // O(n)
		if (nums.length == 1) return 0;

		int sum = 0;
		int res = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= nums[i - 1]) {
				sum += nums[i - 1] - nums[i] + 1;
				nums[i] += sum;
				res += sum;
				sum = 0;
			}
		}

		return res;
	}
}
