package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {
  boolean divideArray(int[] nums) {
    int n = nums.length;

    Map<Integer, Integer> occurances = new HashMap<>();

    for (int num: nums) {
      int value = num;
      if (occurances.containsKey(value)) {
        occurances.replace(value, occurances.get(value) + 1);
      } else {
        occurances.put(value, 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry: occurances.entrySet()) {
      if (entry.getValue() % 2 == 1) {
        return false;
      }
    }

    return true;
  }
}
