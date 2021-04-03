package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    int maxHappyGroupsBruteForce(int batchSize, int[] groups) {
        if (groups.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;

        for (int g: groups) {
            int rem = g % batchSize;
            if (rem != 0) {
                if (map.containsKey(rem)) {
                    map.replace(rem, map.get(rem) + 1);
                } else {
                    map.put(rem, 1);
                }
            } else {
                counter ++;
            }
        }

        counter = dfs(batchSize, map, counter);

        return counter;
    }

    private int dfs(int batchSize, Map<Integer, Integer> map, int counter) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = findComplement(map, entry.getKey(), batchSize);
            if (complement > 0 && entry.getValue() > 0) {
                map.replace(entry.getKey(), entry.getValue() - 1);
                map.replace(complement, map.get(complement) - 1);
                counter++;
            }
        }
        return dfs(batchSize, map, counter);
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

