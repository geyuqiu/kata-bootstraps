package leetcode;

import java.util.HashMap;

public class TwoSumTwo {
    int[] twoSumTwo(int[] numbers, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=0; i<numbers.length; i++) {
            hs.put(numbers[i], i);
        }
        for(int i=0; i<numbers.length; i++) {

            int index = hs.getOrDefault(target - numbers[i], -1);
            if (index != -1) {
                return new int[] {i+1, index+1 };
            }
        }
        return new int[] {};
    }
}
