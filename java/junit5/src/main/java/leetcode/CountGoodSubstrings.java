package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author YUQIU
 */
public class CountGoodSubstrings {
	int countGoodSubstrings(String s) {
		if (s.length() < 3) return 0;
		int sum = 0;

		for (int i = 2; i < s.length(); i++) {
			boolean added = true;
			int start = i - 2;
			HashMap<Character, Boolean> map = new HashMap<>();
			for (int j = start; j <= i; j++) {
				char c = s.charAt(j);
				if (map.containsKey(c)) {
					added = false;
					break;
				} else {
					map.put(c, true);
				}
			}
			if (added) sum++;
		}

		return sum;
	}
}
