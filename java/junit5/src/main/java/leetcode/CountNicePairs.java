package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs { // https://leetcode.com/problems/count-nice-pairs-in-an-array/
    int countNicePairs(int[] nums) { // time: O(n), space: O(n)
        long count = 0;
        Map<Integer, Integer> diffOccurs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - reverse(nums[i]);
            if (diffOccurs.containsKey(diff)) diffOccurs.replace(diff, diffOccurs.get(diff) + 1);
            else diffOccurs.put(diff, 1);
        }

        for (Map.Entry<Integer, Integer> entry: diffOccurs.entrySet()) count += sum(entry.getValue());
        return (int) (count % 1000000007);
    }

    long sum(int value) { // int will produce overflow
        return (long) value*(value-1)/2;
    }

    int reverse(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    int countNicePairsTooSlow(int[] nums) { // O(n^2) brute force too slow
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + reverse(nums[j]) == nums[j] + reverse(nums[i])) { // duplicated work
                    result++;
                }
            }
        }
        return result;
    }
}

