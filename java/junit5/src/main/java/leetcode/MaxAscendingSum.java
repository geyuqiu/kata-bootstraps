package leetcode;

/**
 * @author YUQIU
 */
public class MaxAscendingSum { // https://leetcode.com/problems/maximum-ascending-subarray-sum/submissions/


	int maxAscendingSumBruteforce(int[] nums) { // O(n^2)
		int sum = 0;
		int result = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			result = 0;
			// System.out.println(sum);
			for (int j = i; j < nums.length; j++) {

				if (j + 1 < nums.length && nums[j + 1] > nums[j]) {
					sum += nums[j];
					//  System.out.println("if: " + sum);
				} else {
					result = Math.max(result, sum + nums[j]);
					// System.out.println("else: " + result);
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
