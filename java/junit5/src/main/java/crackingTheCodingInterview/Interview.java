package crackingTheCodingInterview;

/**
 *
 */
public class Interview {
	int solution(int[] A) { // O(n * n)
		int i;
		int j;
		boolean leftBoundarySet = false;
		boolean rightBoundarySet = false;

		for (i = 0, j = A.length-1; i < A.length && j>i;) {
			if (leftBoundarySet && rightBoundarySet) break;
			int li = getIndex(A, i+1, j, A[i]);
			if (li >= 0) {
				i++;
			} else {
				leftBoundarySet = true;
			}
			int ri = getIndex(A, i, j-1, A[j]);
			if (ri >= 0) {
				j--;
			} else {
				rightBoundarySet = true;
			}
		}

		return j-i + 1;
	}

	private int getIndex(int[] a, int i, int j, int key) {
		for (int k = i; k <=j ; k++) {
			if (key == a[k]) return k;
		}
		return -1;
	}
}
