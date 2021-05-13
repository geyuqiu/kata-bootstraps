package crackingTheCodingInterview;

import java.util.Arrays;

/**
 *
 */
public class Interview {
	int solution(int[] A) { // binary search: O(logn * n)
		int i;
		int j;
		boolean leftBoundarySet = false;
		boolean rightBoundarySet = false;

		for (i = 0, j = A.length-1; i < A.length && j>i;) {
			if (leftBoundarySet && rightBoundarySet) break;
			int li = Arrays.binarySearch(A, i, j+1, A[i]);
			if (li >= 0) {
				i++;
			} else {
				leftBoundarySet = true;
			}
			int ri = Arrays.binarySearch(A, i, j+1, A[j]);
			if (ri >= 0) {
				j--;
			} else {
				rightBoundarySet = true;
			}
		}

		return j-i + 1;
	}


}
