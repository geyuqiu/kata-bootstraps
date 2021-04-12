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
class MKAverage { // space: O(n), time: O(n * logm) for BST insertion and deletion, n: # of calculateMKAverage operations

	int m;
	int k;

	int c = 0;
	List<Integer> nums;
	List<Integer> sortedSlidingWindowIndexes;

	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		nums = new ArrayList<>();
		sortedSlidingWindowIndexes = new ArrayList<>(m+1);
	}

	public void addElement(int num) {
		slideByRemovingElement();

		int indexAdded = binarySearch(num);
		sortedSlidingWindowIndexes.add(indexAdded, c);
		nums.add(num);
		c++;
	}

	void slideByRemovingElement() {
		int n = nums.size();
		if (n >= m) {
			int indexToRemove = n - m;
			sortedSlidingWindowIndexes.remove((Integer) indexToRemove);
		}
	}

	int binarySearch(int key) {

		int low = 0;
		int high = sortedSlidingWindowIndexes.size() - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			long midVal = nums.get(sortedSlidingWindowIndexes.get(mid));

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid;
		}
		return low;
	}

	int calculateMKAverage() {
		if (nums.size() < m) return -1;

		long sum = 0L;
		for (int i = k; i <= m - k - 1; i++) sum += (long) nums.get(sortedSlidingWindowIndexes.get(i));

		return Math.round(sum / (m - 2 * k));
	}
}
