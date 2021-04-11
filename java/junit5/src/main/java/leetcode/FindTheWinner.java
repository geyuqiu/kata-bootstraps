package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YUQIU
 */
public class FindTheWinner { // https://leetcode.com/contest/weekly-contest-236/problems/find-the-winner-of-the-circular-game/
	public int findTheWinner(int n, int k) { // time: O(k*n), space: O(n)
		if (k == 1) return n;

		Set<Integer> p = new HashSet<>();
		for (int i = 1; i <= n; i++) p.add(i);

		boolean[] losers = new boolean[n + 1];

		int i = 0;
		int c = k;

		// true means loser
		while (p.size() > 1) {
			if (++i > n) i = 1;
			if (losers[i] == false) {
				c--;
			}
			if (c == 0) {
				p.remove((Integer) i);
				losers[i] = true;
				c = k;
			}
		}

		return p.stream().findFirst().get(); // WTF: https://stackoverflow.com/questions/8882295/how-to-get-the-first-element-of-the-list-or-set
	}
}
