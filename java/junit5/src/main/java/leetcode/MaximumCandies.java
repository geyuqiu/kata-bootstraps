package leetcode;

import java.util.Arrays;

public class MaximumCandies {
  int maximumCandies(int[] candies, long k) { // TLE
    int maxNumOfCandiesForEachChild = 0;

    double sum = 0;

    int N = candies.length;
    for (int i = 0; i < N; i++) {
      sum += candies[i];
    }
    double max = sum / k;
    if (max < 1) return maxNumOfCandiesForEachChild;

    Arrays.sort(candies);

    for (int i = candies[N - 1]; i > 0 ; i--) {
      if (i <= max && canSplit(candies, k, i)) {
        return i;
      }
    }

    return maxNumOfCandiesForEachChild;
  }

  private boolean canSplit(int[] candies, long numOfChildren, int numOfCandiesEachChild) {
    int numOfPiles = 0;
    for (int i = 0; i < candies.length; i++) {
      numOfPiles += candies[i] / numOfCandiesEachChild;
    }

    return numOfPiles >= numOfChildren;
  }
}
