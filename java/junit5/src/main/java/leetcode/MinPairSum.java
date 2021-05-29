package leetcode;

import java.util.Arrays;

/**
 * @author YUQIU
 */
public class MinPairSum {
	int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int min = -1;

		for (int i = 0, j = nums.length-1; i < j; i++, j--) {
			min = Math.max(min, nums[i] + nums[j]);
		}

		return min;
	}
}
