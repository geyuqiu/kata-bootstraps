package leetcode;

import java.util.Arrays;

/**
 * @author YUQIU
 */
public class MaxDistance {
	int maxDistance(int[] nums1, int[] nums2) { // O(n * logn)
		if (Arrays.equals(nums1, nums2)) return 0;
		int max = 0;
		for (int i = 0; i < nums1.length; i++) {
			int index = binarySearch(nums2, 0, nums2.length, nums1[i]);
//			 System.out.println( nums1[i] + ": " + index);
			if (index > i) {
				max = Math.max(index - i, max);
			}
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

			if (midVal < key) high = mid - 1;
			else if (midVal > key) low = mid + 1;
			else { // key found
				for (int j = mid; j < a.length; j++) {
					if (a[j] == midVal) mid = j; // find last possible insertion index
				}
				return mid;
			}
		}
		return Math.max(0, low - 1);  // key not found.
	}
}
