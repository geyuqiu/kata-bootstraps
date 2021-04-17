package leetcode;

import java.util.Arrays;

/**
 * @author YUQIU
 */
public class MakeStringSorted { // https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/
	int makeStringSortedBruteforce(String s) { // O(s!s^2)
		int res = 0;

		String sorted = getSorted(s);

		while (!s.equals(sorted)) {
			// get i and j
			int i = s.length() - 2;
			int j = s.length() - 1;

			outerloop:
			for (; i >= 0; i--) { // O(s^2)
				for (j = s.length() - 1; j >= i; j--) {
					if (s.charAt(i) > s.charAt(j))
						break outerloop;
				}
			}

			String swapped = swap(s, i, j);
			String reversedSubstring = reverse(swapped.substring(i + 1));
			s = swapped.substring(0, i + 1) + reversedSubstring;

			res++;
		}

		return res % (1000000007);
	}

	private String reverse(String toReverse) { // O(s)
		return new StringBuilder(toReverse).reverse().toString();
	}

	private String swap(String s, int i, int j) { // O(1)
		StringBuilder sb = new StringBuilder(s);

		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);

		return sb.toString();
	}

	private String getSorted(String s) { // O(slogs)
		char[] chars = s.toCharArray();

		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted;
	}
}
