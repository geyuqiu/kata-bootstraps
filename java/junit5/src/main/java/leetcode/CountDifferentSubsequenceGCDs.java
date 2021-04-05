package leetcode;

/**
 * @author YUQIU
 */
public class CountDifferentSubsequenceGCDs { // https://leetcode.com/problems/number-of-different-subsequences-gcds/
	// 1 <= nums.length <= 10^5
	// 1 <= nums[i] <= 2 * 10^5
	int countDifferentSubsequenceGCDs(int[] nums) { // time: O( M * log(M) * log(M)), space : O(M), M: max of nums[i]

		int len = getMax(nums);
		boolean[] exists = new boolean[len + 1];

		for (int n : nums) exists[n] = true;

		int gcdCount = 0;
		for (int i = 1; i < len; i++)
			if (subsequenceFound(exists, i))
				gcdCount++;

		return gcdCount;
	}

	private int getMax(int[] nums) {
		int max = 0;
		for (int n: nums) max = Math.max(n, max);

		return max;
	}

	boolean subsequenceFound(boolean[] exists, int factor) {
		int calculatedGcd = 0; //gcd(0, X) -> X

		for (int i = factor; i < exists.length; i += factor) {
			if (exists[i]) calculatedGcd = gcd(calculatedGcd, i); // gcd(2*3,2*5) = 2
			if (calculatedGcd == factor) return true; // gcd(4,16) = 4 != 2
		}
		return false;
	}

	int gcd(int a, int b) { // O(log(a+b))
		if (a % b == 0) return b;
		else return gcd(b, a % b);
	}
}
