package leetcode;

/**
 * @author YUQIU
 */
public class CountDifferentSubsequenceGCDs { // https://leetcode.com/problems/number-of-different-subsequences-gcds/
	// 1 <= nums.length <= 10^5
	// 1 <= nums[i] <= 2 * 10^5
	int countDifferentSubsequenceGCDs(int[] nums) { // time: O( M * log(M) * log(M)), space : O(M), M: max of nums[i]

		int max = 0;
		for (int n: nums) {
			max = Math.max(n, max);
		}

		int len = max + 1;
		boolean[] exists = new boolean[len];
		for (int n : nums) {
			exists[n] = true;
		}

		int gcdCount = 0;
		for (int i = 1; i < len; i++) { // 0 not treated
			boolean found = checkGcdIFold(exists, i);
			if (found) gcdCount++;
		}
		return gcdCount;
	}

	boolean checkGcdIFold(boolean[] exists, int gcd) {
		//gcd(0, X) -> X
		int calculatedGcd = 0;

		for (int i = gcd; i < exists.length; i += gcd) {
			if (exists[i]) {
				calculatedGcd = gcd(calculatedGcd, i); // gcd(2*3,2*5) = 2
			}
			// gcd(4,16) = 4 != 2
			if (calculatedGcd == gcd) {
				return true;
			}
		}
		return false;
	}

	int gcd(int a, int b) { // O(log(a+b))
		if (a % b == 0) return b;
		else return gcd(b, a % b);
	}
}
