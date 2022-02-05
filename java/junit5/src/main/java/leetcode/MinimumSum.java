package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumSum {
  int minimumSum(int num) {
    int min = Integer.MAX_VALUE;

    String stringValue = String.valueOf(num);
    int length = stringValue.length();
    int[] array = new int[length];
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < length; i++) {
      int intValue = stringValue.charAt(i) - '0';
      array[i] = intValue;
      list.add(intValue);
    }

    List<Integer> tempList;

    List<List<Integer>> results = subsets(array);
    for (List<Integer> result: results) {
      tempList = new ArrayList<>(list);
      String removed = "";
      for (int value: result) {
        tempList.remove((Integer) value);
        removed += value;
      }
      String res = "";
      for (int n: tempList) {
        res += n;
      }
      int sum = Integer.valueOf(res) + Integer.valueOf(removed);
      min = Math.min(sum, min);
      System.out.println(res + " " + removed);
    }

    System.out.println(results);
    return min;
  }

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> subset = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) { // time: O(2^n), space O(n)
    backtracking(nums, 0);
    return result;
  }

  void backtracking(int[] nums, int pos) {
    if (pos == nums.length) {
      List copy = new ArrayList<Integer>();
      copy.addAll(subset);
      if (!result.contains(copy) && !copy.isEmpty() && copy.size() != nums.length) {
        result.add(copy);
      }
    } else {
      backtracking(nums, pos + 1);
      subset.add(nums[pos]);
      backtracking(nums, pos + 1);
      subset.remove(subset.size() - 1);
    }
  }
}
