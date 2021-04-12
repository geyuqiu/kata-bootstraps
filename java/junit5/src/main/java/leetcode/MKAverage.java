package leetcode;

import java.util.*;

/**
 * @author YUQIU
 * n: 10^5
 * m: 10^5
 * k: 10^5 / 2
 * save sliding window elements as sorted list as BST array ?
 * similar to this: https://leetcode.com/problems/sliding-window-maximum/, how do I persist the rest of k-2 elements ?
 */
class MKAverage { // space: O(n), time: O(n) but for sorting alone: O(n * mlogm), n: # of calculateMKAverage operations

	int m;
	int k;
	List<Integer> nums;
	List<Integer> sortedSlidingWindowIndexes;

	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		nums = new ArrayList<>();
		sortedSlidingWindowIndexes = new ArrayList<>(m+1);
	}

	public void addElement(int num) {

		int indexAdded = binarySearch();
		sortedSlidingWindowIndexes.add(indexAdded, nums.size());
		nums.add(num);
	}

	int binarySearch() {

		return 0;
	}

	int calculateMKAverage() {
		long sum = 0L;
		for (int i = k; i <= m - k - 1; i++) sum += (long) sortedSlidingWindowIndexes.get(i);

		return Math.round(sum / (m - 2 * k));
	}
}
