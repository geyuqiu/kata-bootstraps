package leetcode;

public class FindMiddleIndex {
    int findMiddleIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int prefixSum = 0;
        int suffixSum = sum;
        suffixSum -= nums[0];
        if (prefixSum == suffixSum) return 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i-1];

            suffixSum -= nums[i];
            if (prefixSum == suffixSum) return i;
        }
        return -1;
    }
}
