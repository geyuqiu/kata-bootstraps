package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    int maxHappyGroupsBruteForce(int batchSize, int[] groups) {
        if (groups.length == 0) return 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int g: groups) {
            if (g % batchSize != 0) map.put(g, false);
        }

        int counter = groups.length - map.size();

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            int complement = findComplement(map, entry.getKey(), batchSize);
            if (complement != -1 && !entry.getValue()) {
                map.replace(entry.getKey(), true);
                map.replace(complement, true);
                counter++;
            }
        }

        return counter;
    }

    private int findComplement(Map<Integer, Boolean> map, Integer entryKey, int batchSize) {
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if ((entryKey + entry.getKey()) % batchSize == 0 && !entry.getValue()){
                return entry.getKey();
            }
        }
        return -1;
    }

}

