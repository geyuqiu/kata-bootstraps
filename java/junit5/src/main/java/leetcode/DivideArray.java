package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {
  boolean divideArray(int[] nums) {
    Map<Integer, Integer> occurrences = new HashMap<>();

    for (int num: nums) {
      int value = num;
      if (occurrences.containsKey(value)) {
        occurrences.replace(value, occurrences.get(value) + 1);
      } else {
        occurrences.put(value, 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry: occurrences.entrySet()) {
      if (entry.getValue() % 2 == 1) {
        return false;
      }
    }

    return true;
  }
}
