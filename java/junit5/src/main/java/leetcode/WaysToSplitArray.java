package leetcode;

public class WaysToSplitArray {
  int waysToSplitArray(int[] nums) {
    int validSplits = 0;
    long sum = 0;
    long leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    long rightSum = sum;

    for (int i = 0; i < nums.length-1; i++) {
      leftSum += nums[i];
      rightSum -= nums[i];
      if (leftSum >= rightSum) {
        validSplits++;
      }
    }

    return validSplits;
  }
}
