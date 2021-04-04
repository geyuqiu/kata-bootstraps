package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author YUQIU
 */
public class FindingUsersActiveMinutes {
	int[] findingUsersActiveMinutes(int[][] logs, int k) {
		int[] uams = new int[k];
		Map<Integer, HashSet<Integer>> idTimes = new HashMap<>();

		for (int i = 0; i < logs.length; i++) {
			int id = logs[i][0];
			int time = logs[i][1];
			if (idTimes.containsKey(id)) {
				idTimes.get(id).add(time);
			} else {
				HashSet hs = new HashSet<Integer>();
				hs.add(time);
				idTimes.put(id, hs);
			}
		}

		for (Map.Entry<Integer, HashSet<Integer>> e : idTimes.entrySet()) {
			uams[e.getValue().size() - 1]++;
		}
		return uams;
	}
}
