package crackingTheCodingInterview;

/**
 *
 */
public class Interview {
	int solution(int[] A, int S) { // O(n ^ 3)
		int sumOfContiguousFragments = 0;

		for (int i = 0; i < A.length; i++) {
			// j-i is the number of elements which should be in the fragment
			for (int j = i; j < A.length; j++) {
				int sumOfFragments = 0;
				int counter = j-i+1;
				for (int k = i; k <= j; k++) {
//					System.out.print(A[k]);
					sumOfFragments += A[k];
				}
				double mean = (double) sumOfFragments / counter;
				if (mean == Double.valueOf(S)) sumOfContiguousFragments++;
//				System.out.println();
			}
		}

		return sumOfContiguousFragments;
	}
}
