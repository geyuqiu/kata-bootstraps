package leetcode;

import java.util.Arrays;

/**
 * @author YUQIU
 */
public class MaxDistance {
	int maxDistance(int[] nums1, int[] nums2) { // O(n1 * n2)
		int max = 0;
		for (int i = 0; i < nums1.length; i++) {
//			for (int j = i; j < nums2.length; j++) {
//				if (nums1[i] <= nums2[j]) max = Math.max(j - i, max);
//				else break; // non-increasing
//			}
			int index = binarySearch(nums2, 0, nums2.length, nums1[i]);
			System.out.println( nums1[i] + ": " + index);
		}

		return max;
	}

	private static int binarySearch(int[] a, int fromIndex, int toIndex,
									 int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return low;  // key not found.
	}
}
