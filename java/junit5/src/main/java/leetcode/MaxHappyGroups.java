package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    int maxHappyGroupsBruteForce(int batchSize, int[] groups) {
        if (groups.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        int numGroups = 0;

        for (int g: groups) {
            int rem = g % batchSize;
            if (rem != 0) {
                numGroups++;
                if (map.containsKey(rem)) {
                    map.replace(rem, map.get(rem) + 1);
                } else {
                    map.put(rem, 1);
                }
            } else {
                counter ++;
            }
        }

        counter = dfs(batchSize, map, counter, numGroups);

        return counter;
    }

    private int dfs(int batchSize, Map<Integer, Integer> map, int counter, int numGroups) {
        if (numGroups == 0) return counter;
        if (numGroups > 0 && leftOver(batchSize, map)) return ++counter;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = findComplement(map, entry.getKey(), batchSize);
//            if (complement == entry.getKey() && entry.getValue() < 2) continue;
            if (complement > 0 && entry.getValue() > 0) {
                map.replace(entry.getKey(), entry.getValue() - 1);
                map.replace(complement, map.get(complement) - 1);
                counter++;
                numGroups -= 2;
            }
        }
        return dfs(batchSize, map, counter, numGroups);
    }

    private boolean leftOver(int batchSize, Map<Integer, Integer> map) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                sum += entry.getKey() * entry.getValue();
            }
        }
        if (sum < batchSize) return true;
        return false;
    }

    private int findComplement(Map<Integer, Integer> map, Integer entryKey, int batchSize) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((entryKey + entry.getKey()) % batchSize == 0 && entry.getValue() > 0){
                return entry.getKey();
            }
        }
        return -1;
    }
}

