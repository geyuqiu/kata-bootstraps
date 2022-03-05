package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortJumbled {
  // Elements with the same mapped values should appear in the same relative order as in the input.
  int[] sortJumbled(int[] mapping, int[] nums) {
    List<Mapping> mappings = new ArrayList<>();

    // calc mapping
    for (int i = 0; i < nums.length; i++) {
      int number = nums[i];
      String mapped = "";
      while (number > 0) {
        int remainder = number % 10;
        number /= 10;
        mapped = mapping[remainder-1] + mapped;
      }
      mappings.add(new Mapping(nums[i], Integer.parseInt(mapped)));
    }

    // sort values based on mapped
    Collections.sort(mappings, Comparator.comparing(Mapping::getMapped));

    int[] results = new int[nums.length];
    for (int i = 0; i < mappings.size(); i++) {
      results[i] = mappings.get(i).getValue();
    }

    return results;
  }
}

class Mapping {
  int value;
  int mapped;

  public Mapping(int value, int mapped) {
    this.value = value;
    this.mapped = mapped;
  }

  public int getMapped() {
    return mapped;
  }

  public int getValue() {
    return value;
  }
}
