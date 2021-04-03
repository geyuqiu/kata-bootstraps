package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow { // https://leetcode.com/problems/sliding-window-maximum/


    public int[] maxSlidingWindowBruteForce(int[] nums, int k) { // time: O(n * k), too slow
        if (nums.length == 1) return nums;
        int[] localMaxs = new int[nums.length - k + 1];
        for (int start = 0, end = start + k - 1; end < nums.length; start++, end++) {
            int max = findMax(nums, start, end);
            localMaxs[start] = max;
        }
        return localMaxs;
    }

    private int findMax(int[] nums, int start, int end) { // O(k)
        int localMax = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            localMax = localMax > nums[i] ? localMax : nums[i];
        }
        return localMax;
    }
}
