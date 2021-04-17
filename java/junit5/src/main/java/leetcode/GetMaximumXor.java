package leetcode;

/**
 * @author YUQIU
 */
public class GetMaximumXor {// https://leetcode.com/problems/maximum-xor-for-each-query/
	int[] getMaximumXor(int[] nums, int maximumBit) { // O(n)
		int n = nums.length;
		int[] res = new int[n];
		int k = (int) Math.pow(2, maximumBit) - 1;
		int xor = nums[0];
		res[n - 1] = k ^ xor;

		for (int i = 1; i < n; i++) {
			xor ^= nums[i];
			res[n - i - 1] = k ^ xor; // 1 xor 2 = 3 => 3 xor 1 = 2 => 3 xor 2 = 1
		}
		return res;
	}
}
