package leetcode;

public class MinimumAverageDifference {
  int minimumAverageDifference(int[] nums) { // returns index of minimum average difference
    int minIndex = 0;
    long minAverageDiff = Long.MAX_VALUE;
    long sum = 0;
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      sum += nums[i];
    }

    long leftSum = 0L;
    long rightSum = 0L;
    for (int i = 0; i < N; i++) { // TLE: runtime with O(n^2)
      int lefts = i+1;
      int rights = N - lefts;

      leftSum += nums[i];
      rightSum = sum - leftSum;

      long nullable = rights == 0 ? 0 : rightSum / rights;
      long cAverageDiff = Math.abs(leftSum / lefts - nullable);
      if (cAverageDiff < minAverageDiff) {
        minAverageDiff = cAverageDiff;
        minIndex = i;
      }
    }

    return minIndex;
  }
}
