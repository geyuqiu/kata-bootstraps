package leetcode;

/**
 * @author YUQIU
 */
public class SumOfFlooredPairs {
	int sumOfFlooredPairs(int[] nums) { // brute force O(N*N)
		int N = nums.length;
		int sum=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += nums[i] / nums[j];
			}
		}
		return sum;
	}
}
