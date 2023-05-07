package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {
    int[] distinctDifferenceArray(int[] nums) {
        int L = nums.length;
        int[] result = new int[L];

        for (int i = 0; i < L; i++) {
            Set<Integer> prefix = new HashSet<>();
            Set<Integer> suffix = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                prefix.add(nums[j]);
            }
            for (int j = i+1; j < L; j++) {
                suffix.add(nums[j]);
            }
            result[i] = prefix.size() - suffix.size();
        }
        
        return result;
    }
}
