package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                map.replace(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value =  entry.getValue();
            if (value > nums.length / 2) {
                return entry.getKey();
            }
        }

        return max;
    }
}
