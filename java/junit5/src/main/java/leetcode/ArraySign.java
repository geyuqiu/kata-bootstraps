package leetcode;

/**
 * @author YUQIU
 */
public class ArraySign { // https://leetcode.com/contest/weekly-contest-236/problems/sign-of-the-product-of-an-array/
	public int arraySign(int[] nums) { // O(n)
		if (nums.length == 1) return checkSign(nums[0]);

		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = checkSign(result, nums[i]);
		}
		return result;
	}

	int checkSign(int a, int b) {
		if (a == 0 || b == 0) return 0;
		if (a < 0 && b < 0 || a > 0 && b > 0) return 1;
		return -1;
	}

	int checkSign(int a) {
		if (a == 0) return 0;
		if (a < 0) return -1;
		return 1;
	}
}
