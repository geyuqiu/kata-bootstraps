package leetcode;

public class MaximizeSum {
  int maximizeSum(int[] nums, int k) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
    }
    int result = 0;
    for (int i = 0; i < k; i++) {
      result += max + i;
    }

    return result;
  }
}
