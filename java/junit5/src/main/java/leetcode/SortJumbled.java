package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortJumbled {
  // Elements with the same mapped values should appear in the same relative order as in the input.
  int[] sortJumbled(int[] mapping, int[] nums) {
    List<Mapping> mappings = calcMappings(mapping, nums);

    Collections.sort(mappings,
      Comparator.comparing(Mapping::getMapped)
        .thenComparing(Mapping::getIndex)
    );

    int[] results = new int[nums.length];
    for (int i = 0; i < mappings.size(); i++) {
      results[i] = mappings.get(i).getValue();
    }

    return results;
  }

  private List<Mapping> calcMappings(int[] mapping, int[] nums) {
    List<Mapping> mappings = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int number = nums[i];
      String mapped = "";
      if (number == 0) mapped = mapping[0] + "";
      while (number > 0) {
        int remainder = number % 10;
        number /= 10;
        mapped = mapping[remainder] + mapped;
      }
      mappings.add(new Mapping(nums[i], Integer.parseInt(mapped), i));
    }
    return mappings;
  }
}

class Mapping {
  int value;
  int mapped;
  int index;

  public Mapping(int value, int mapped, int index) {
    this.value = value;
    this.mapped = mapped;
    this.index = index;
  }

  public int getMapped() {
    return mapped;
  }

  public int getValue() {
    return value;
  }

  public int getIndex() {
    return index;
  }
}
