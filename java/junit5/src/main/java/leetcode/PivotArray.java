package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class PivotArray {
  int[] pivotArray(int[] nums, int pivot) {
    Item[] items = new Item[nums.length];
    for (int i = 0; i < nums.length; i++) {
      items[i] = new Item(nums[i], i);
    }

    Arrays.sort(items, Comparator
      .comparing(Item::getNum));
    int pivotStart = 0;
    int pivotEnd = 0;
    for (int i = 0; i < items.length; i++) {
      if (items[i].num == pivot) {
        pivotStart = i;
        break;
      }
    }
    for (int i = items.length-1; i >= 0; i--) {
      if (items[i].num == pivot) {
        pivotEnd = i;
        break;
      }
    }

    Arrays.sort(items, 0, pivotStart, Comparator
      .comparing(Item::getIndex));
    Arrays.sort(items, pivotEnd+1, nums.length, Comparator
      .comparing(Item::getIndex));


    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = items[i].num;
    }

    return res;
  }
}

class Item{
  int num;
  int index;

  public int getNum() {
    return num;
  }

  public int getIndex() {
    return index;
  }

  public Item(int num, int index) {
    this.num = num;
    this.index = index;
  }
}
