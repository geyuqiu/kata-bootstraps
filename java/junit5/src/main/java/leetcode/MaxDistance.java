package leetcode;

/**
 * @author YUQIU
 */
public class MaxDistance {
	int maxDistance(int[] nums1, int[] nums2) { // O(n * n)
		int max = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = i; j < nums2.length; j++) {
				if (nums1[i] <= nums2[j]) max = Math.max(j - i, max);
			}
		}

		return max;
	}
}
