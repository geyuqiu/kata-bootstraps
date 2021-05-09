package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YUQIU
 */
public class MaximumPopulation {
	int maximumPopulation(int[][] logs) { // space: O(n), time: O(n)
		Map<Integer, Integer> yearOccurance = new HashMap<>();

		for (int i = 0; i < logs.length; i++) {
			int birth = logs[i][0];
			int death = logs[i][1];
			// Note that the person is not counted in the year that they die.
			for (int j = birth; j < death; j++) { // max: 100
				if (yearOccurance.containsKey(j)) {
					yearOccurance.replace(j, yearOccurance.get(j) + 1);
				} else {
					yearOccurance.put(j, 1);
				}
			}
		}

		int maxYear = logs[0][0];
		int max = 0;

		for (Map.Entry<Integer, Integer> entry : yearOccurance.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				maxYear = entry.getKey();
			} else if (entry.getValue() == max && entry.getKey() < maxYear) {
				maxYear = entry.getKey(); // the earliest year
			}
		}

		return maxYear;
	}
}
