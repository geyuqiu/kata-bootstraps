package leetcode;

public class MinimumAverageDifference {
  int minimumAverageDifference(int[] nums) { // returns index of minimum average difference
    int minIndex = 0;
    int minAverageDiff = Integer.MAX_VALUE;
    int sum = 0;
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      sum += nums[i];
    }

    int leftSum = 0;
    int rightSum = 0;
    for (int i = 0; i < N; i++) { // TLE: runtime with O(n^2)
      int lefts = i+1;
      int rights = N - lefts;

      for (int j = 0; j <= i; j++) {
        leftSum += nums[j];
      }
      rightSum = sum - leftSum;
      int nullable = rights == 0 ? 0 : rightSum / rights;
      int cAverageDiff = Math.abs(leftSum / lefts - nullable);
      if (cAverageDiff < minAverageDiff) {
        minAverageDiff = cAverageDiff;
        minIndex = i;
      }

      // reset
      leftSum = 0;
      rightSum = 0;
    }

    return minIndex;
  }
}
