package leetcode;

import java.util.HashMap;
import java.util.Map;

// understand the recursive solution here https://github.com/geyuqiu/kata-bootstraps/blob/master/java/junit5/src/main/java/crackingTheCodingInterview/listOfStringPermutations.java first :)
public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    Map<String, Integer> modRemainders = new HashMap<>();

	int maxHappyGroups(int batchSize, int[] groups) { //
        int[] remainders = new int[batchSize];
        for (int numOfCustomer : groups) {
            remainders[numOfCustomer % batchSize]++;
        }
        int happyGroups = remainders[0];
        remainders[0] = 0; // start dfs from 1
        int ans = remaindersPermutations(0, remainders);

        return ans + happyGroups;
    }

    int remaindersPermutations(int mod, int[] remainders) {
		if (checkBaseCase(remainders)) return 0;

        int firstGroupGetsFreshDonuts = (mod == 0) ? 1 : 0;
        int max = 0;
        for (int i = 1; i < remainders.length; i++) {
            if (remainders[i] > 0) {
                remainders[i]--;
                max = Math.max(max, remaindersPermutations((mod + i) % remainders.length, remainders));
                remainders[i]++;
            }
        }

        return max + firstGroupGetsFreshDonuts;
    }

	private boolean checkBaseCase(int[] remainders) {
		for (int i = 1; i < remainders.length; i++) {
			if (remainders[i] != 0) {
				return false;
			}
		}
		return true;
	}
	// exponential complexity without dp
}

