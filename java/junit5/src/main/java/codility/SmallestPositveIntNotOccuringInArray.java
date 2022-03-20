package codility;

import java.util.Arrays;

public class SmallestPositveIntNotOccuringInArray {
  public int smallestPositveIntNotOccuringInArray(int[] A) {
    Arrays.sort(A);

    int min = 1;

    for (int i = 0; i < A.length; i++) {
      if (min == A[i]) {
        min++;
      }
    }
    return min;
  }
}
