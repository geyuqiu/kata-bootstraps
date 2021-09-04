package leetcode;

import java.util.Arrays;

public class SearchInsert {
    int searchInsert(int[] nums, int target) {
        int jip = Arrays.binarySearch(nums, target);

        int result = jip >= 0 ? jip : (-(jip+1));

        return result;
    }
}
