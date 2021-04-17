package leetcode;

/**
 * @author YUQIU
 */
public class MaxAscendingSum { // https://leetcode.com/problems/maximum-ascending-subarray-sum/submissions/
	int maxAscendingSum(int[] nums) { // O(n)
		int max = nums[0];
		int result = max;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				max = max + nums[i];
				result = Math.max(result, max);
			} else {
				max = nums[i];
			}
		}
		return result;
	}

	int maxAscendingSumBruteforce(int[] nums) { // O(n^2)
		int sum = 0;
		int result = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			result = 0;
			for (int j = i; j < nums.length; j++) {

				if (j + 1 < nums.length && nums[j + 1] > nums[j]) {
					sum += nums[j];
				} else {
					result = Math.max(result, sum + nums[j]);
					sum = nums[i];
					break;
				}
			}
			result = Math.max(result, sum);
			max = Math.max(result, max);
		}

		return max;
	}
}
