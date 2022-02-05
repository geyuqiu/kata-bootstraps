package leetcode;

import java.util.Arrays;

import org.jetbrains.annotations.NotNull;

public class PivotArray {
  int[] pivotArray(int[] nums, int pivot) {
    Item[] items = new Item[nums.length];
    for (int i = 0; i < nums.length; i++) {
      items[i] = new Item(nums[i], i);
    }

    Arrays.sort(items);

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = items[i].num;
    }

    return res;
  }
}

class Item implements Comparable<Item>{
  int num;
  int index;

  public Item(int num, int index) {
    this.num = num;
    this.index = index;
  }

  @Override
  public int compareTo(@NotNull Item i) {
    int compareIndex = ((Item) i).index;
    return this.index - compareIndex;
  }
}
