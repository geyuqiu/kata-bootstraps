package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numIndex = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int c = target - nums[i];
            if (numIndex.containsKey(c)) {
                res[0] = i;
                res[1] = numIndex.get(c);
            }
            numIndex.put(nums[i], i);
        }

        return res;
    }
}
