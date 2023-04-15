package leetcode;

public class FindPrefixScore {
  long[] findPrefixScore(int[] nums) {
    long[] conversions = new long[nums.length];
    long[] intermediateSum = new long[nums.length];
    int max = 0;
    long sum = 0l;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) max = nums[i];
      conversions[i] = max + nums[i];
      sum += conversions[i];
      intermediateSum[i] = sum;
    }

    return intermediateSum;
  }
}
