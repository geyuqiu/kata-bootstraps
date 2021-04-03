package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YUQIU
 */
public class CountConsistentStrings { // https://leetcode.com/problems/count-the-number-of-consistent-strings/
	int countConsistentStrings(String allowed, String[] words) { // time: O(W), space: O(A)
		Map<Character, Boolean> appearance = new HashMap<>();
		int len = allowed.length();
		for (int i = 0; i < len; i++) {
			appearance.put(allowed.charAt(i), true);
		}

		int result = 0;
		for (String str : words) {
			boolean invalidChar = true;
			for (char c : str.toCharArray()) {
				if (appearance.get(c) == null) {
					invalidChar = false;
					break;
				}
			}
			if (invalidChar) {
				result++;
			}
		}
		return result;
	}
}
