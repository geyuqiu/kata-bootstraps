package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow { // https://leetcode.com/problems/sliding-window-maximum/
    public int[] maxSlidingWindow(int[] nums, int k) { // time: O(n), space: O(1)
        int length = nums.length;
        int[] localMaxs = new int[length - k + 1];

        Deque<Integer> indexDeQue = new LinkedList<>(); // first element: nums[indexDeQue.getFirst()] always the max

        for (int i = 0; i < length; i++) {
            // 1. adapt to window size (remove 0. element) if i-k = head = 0 for [7,4,5,6]
            if (!indexDeQue.isEmpty() && i - k == indexDeQue.getFirst()) {
                indexDeQue.removeFirst();
            }

            // 2. delete the tail of queue one by one if tail smaller than nums[i], because local max is nums[i]
            while (!indexDeQue.isEmpty() && nums[indexDeQue.getLast()] < nums[i]) {
                indexDeQue.removeLast();
            }

            // 3. add element index to the back of the dequeue, at the back, because they could be next potential local max because of the sliding window to right direction
            indexDeQue.addLast(i);

            // 4. add indexDeque head to localMaxs
            if (i >= k - 1) localMaxs[i - k + 1] = nums[indexDeQue.getFirst()];
        }

        return localMaxs;
    }

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
