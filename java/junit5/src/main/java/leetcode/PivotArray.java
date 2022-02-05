package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PivotArray {
  int[] pivotArray(int[] nums, int pivot) {
    List<Integer> smaller = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> bigger = new ArrayList<>();

    for (int n: nums) {
      if (n < pivot) smaller.add(n);
      else if (n == pivot) equal.add(n);
      else bigger.add(n);
    }

    smaller.addAll(equal);
    smaller.addAll(bigger);

    return smaller.stream().mapToInt(Integer::intValue).toArray();
  }
}
