package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
  // target comes directly after key
  // count the number of times target immediately follows an occurrence of key in nums
  // return maximum count target (not index)
  // target can be equal to key
  int mostFrequent(int[] nums, int key) {
    int times = 0;
    int result = -1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length-1; i++) {
      int nextNumberAsTarget = nums[i+1];
      if (nums[i] == key) {
        if (map.containsKey(nextNumberAsTarget)) {
          map.replace(nextNumberAsTarget, map.get(nextNumberAsTarget) + 1);
        } else {
          map.put(nextNumberAsTarget, 1);
        }
      }
    }

    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
      if (entry.getValue() > times) {
        times = entry.getValue();
        result = entry.getKey();
      }
    }

    return result;
  }
}
