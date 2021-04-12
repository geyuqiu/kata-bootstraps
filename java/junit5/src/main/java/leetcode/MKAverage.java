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
class MKAverage { // space: O(n), time: O(n) for BST insertion and deletion (move complexity from calculateMKAverage to addElement)

	int m;
	int k;
	int restLength;

	List<Integer> nums = new ArrayList<>(); // n
	List<Integer> sortedSlidingWindowIndexes = new ArrayList<>(); // m

	public MKAverage(int m, int k) {
		this.m = m;
		this.k = k;
		this.restLength = m - 2 * k;
	}

	public void addElement(int num) {
		slideByRemovingElement();

		sortedSlidingWindowIndexes.add(binarySearch(num), nums.size()); // O(n)
		nums.add(num);
	}

	void slideByRemovingElement() {
		int n = nums.size();
		if (n >= m) sortedSlidingWindowIndexes.remove((Integer) (n - m)); // O(n)
	}

	int binarySearch(int key) {  // O(log m)
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

	int calculateMKAverage() { // O(k)
		if (nums.size() < m) return -1;

		long sum = 0L;
		for (int i = k; i <= m - k - 1; i++) sum += (long) nums.get(sortedSlidingWindowIndexes.get(i));

		return Math.round(sum / restLength);
	}
}
