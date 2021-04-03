package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    int maxHappyGroupsBruteForce(int batchSize, int[] groups) {
        if (groups.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int g: groups) {
            if (g % batchSize != 0) {
                if (map.containsKey(g)) {
                    map.replace(g, map.get(g) + 1);
                } else {
                    map.put(g, 1);
                }
            }
        }

        int counter = groups.length - map.size();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = findComplement(map, entry.getKey(), batchSize);
            if (complement > 0 && entry.getValue() > 0) {
                map.replace(entry.getKey(), entry.getValue() - 1);
                map.replace(complement, entry.getValue() - 1);
                counter++;
            }
        }

        return counter;
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

