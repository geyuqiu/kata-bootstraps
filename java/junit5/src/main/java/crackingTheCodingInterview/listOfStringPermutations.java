package crackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=GuTPwotSdYw
 */
public class listOfStringPermutations { // time: O(n * n!), space: O(n!)
	List<String> permutations = new ArrayList<>();

	List<String> permutation (String str) {
		permutation(str, 0, str.length() - 1);
		return permutations;
	}

	void permutation(String str, int l, int r) {
		if (l == r)
			permutations.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permutation(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
