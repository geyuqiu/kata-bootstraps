package leetcode;

import java.util.Arrays;

/**
 * @author YUQIU
 */
public class MaxFrequency {
	int maxFrequency(int[] nums, int k) { // O(n^2)
		if (nums.length == 1) return 1;

		int res = 0;
		int temp;
		int c;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			temp = k;
			c = 0;
			for (int j = 2; j <= i; j++) {
				temp -= nums[i] - nums[j];
				if (temp<0) {
					break;
				} else {
					c++;
				}
			}
			if (c > res) {
				res = c;
			}
		}
		return Math.max(1, res);
	}
}
