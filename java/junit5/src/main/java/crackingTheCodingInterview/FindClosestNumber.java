package crackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestNumber {
  int findClosestNumber(int[] nums) {
    int N = nums.length;

    List<Integer> potentialSameValues = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      int value = Math.abs(nums[i]);
      if (value < min) {
        min = value;
        potentialSameValues.clear();
        potentialSameValues.add(nums[i]);
      } else if (value == min) {
        potentialSameValues.add(nums[i]);
      }
    }

    if (potentialSameValues.size() > 1) {
      return Collections.max(potentialSameValues);
    }

    return potentialSameValues.get(0);
  }
}
