package leetcode;

/**
 * @author YUQIU
 */
public class MinAbsoluteSumDiff {
	int minAbsoluteSumDiff(int[] nums1, int[] nums2) { // 1 <= nums1[i], nums2[i] <= 10^5, 1 <= n <= 105
		int n = nums1.length;
		int[] diff = new int[n];

		// initialize
		int maxDiffIndex = 0;
		int maxDiff = Math.abs(nums1[0] - nums2[0]);
		diff[0] = maxDiff;

		// diffs, find max diff pos
		for (int i = 1; i < n; i++) {
			diff[i] = Math.abs(nums1[i] - nums2[i]);
			if (diff[i] > maxDiff) {
				maxDiff = diff[i];
				maxDiffIndex = i;
			}
		}

		long minAbsoluteSumDiff = 0L;
		int min = diff[maxDiffIndex];

		// add other values to minAbsoluteSumDiff (Long)
		// find a num MIN in nums1, so that Math.min(MIN, |nums1(i)-nums2(maxDiffIndex)|) && num != nums1(maxDiffIndex)
		for (int i = 0; i < n; i++) {
			min = Math.min(min, Math.abs(nums1[i] - nums2[maxDiffIndex]));
			if (i != maxDiffIndex) minAbsoluteSumDiff += (long) diff[i];
		}

		return (int) ((minAbsoluteSumDiff + (long) min) % 1000000007);
	}
}
