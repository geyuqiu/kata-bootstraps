package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// understand this recursive solution here https://github.com/geyuqiu/kata-bootstraps/blob/master/java/junit5/src/main/java/crackingTheCodingInterview/listOfStringPermutations.java first :)
public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    Map<String, Integer> modRemaindersCounter = new HashMap<>();  // TLE without dp

	int maxHappyGroups(int batchSize, int[] groups) { // time and space: O((G/K)^K*K), B = K/2
        int[] remaindersCounter = new int[batchSize];
        int sumOfLeftRemaindersCounter = 0;
        for (int numOfCustomer : groups) {
            remaindersCounter[numOfCustomer % batchSize]++;
            sumOfLeftRemaindersCounter++;
        }

        int happyGroups = remaindersCounter[0];
        sumOfLeftRemaindersCounter -= happyGroups;
        remaindersCounter[0] = 0; // start dfs from 1
        int ans = remaindersPermutations(0, remaindersCounter, sumOfLeftRemaindersCounter);

        return ans + happyGroups;
    }

    int remaindersPermutations(int mod, int[] remaindersCounter, int sumOfLeftRemaindersCounter) {
		if (sumOfLeftRemaindersCounter == 0) return 0;

		String key = mod +"," + Arrays.toString(remaindersCounter);
		if (modRemaindersCounter.containsKey(key)) {
			return modRemaindersCounter.get(key);
		}

        int firstGroupGetsFreshDonuts = (mod == 0) ? 1 : 0;
        int max = 0;
        for (int i = 1; i < remaindersCounter.length; i++) {
            if (remaindersCounter[i] > 0) {
                remaindersCounter[i]--; sumOfLeftRemaindersCounter--;
                max = Math.max(max, remaindersPermutations((mod + i) % remaindersCounter.length, remaindersCounter, sumOfLeftRemaindersCounter));
                remaindersCounter[i]++; sumOfLeftRemaindersCounter++;
            }
        }

        mod = max + firstGroupGetsFreshDonuts;
		modRemaindersCounter.put(key, mod);
		return mod;
    }
}

