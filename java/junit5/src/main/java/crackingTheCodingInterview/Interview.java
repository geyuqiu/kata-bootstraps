package crackingTheCodingInterview;

/**
 *
 */
public class Interview {
	int solution(int[] A) { // O(n * n)
		int leftAndRight = leftAndRight(A);
		int onlyLeft = onlyLeft(A);
		int onlyRight = onlyRight(A);

		return Math.min(leftAndRight, Math.min(onlyLeft, onlyRight));
	}

	private int leftAndRight(int[] a) {
		int i;
		int j;
		boolean leftBoundarySet = false;
		boolean rightBoundarySet = false;

		for (i = 0, j = a.length-1; i < a.length && j>i;) {
			if (leftBoundarySet && rightBoundarySet) break;
			int li = getIndex(a, i+1, j, a[i]);
			if (li >= 0) {
				i++;
			} else {
				leftBoundarySet = true;
			}
			int ri = getIndex(a, i, j-1, a[j]);
			if (ri >= 0) {
				j--;
			} else {
				rightBoundarySet = true;
			}
		}

		int leftAndRight = j - i + 1;
		return leftAndRight;
	}

	private int onlyLeft(int[] a) {
		int i;

		for (i = 0; i < a.length;) {
			int li = getIndex(a, i+1, a.length - 1, a[i]);
			if (li >= 0) {
				i++;
			} else {
				break;
			}
		}

		return a.length - i;
	}

	private int onlyRight(int[] a) {
		int i;

		for (i = a.length-1; i >= 0;) {
			int li = getIndex(a, 0, i-1, a[i]);
			if (li >= 0) {
				i--;
			} else {
				break;
			}
		}

		return i + 1;
	}

	private int getIndex(int[] a, int i, int j, int key) {
		for (int k = i; k <=j ; k++) {
			if (key == a[k]) return k;
		}
		return -1;
	}
}
