package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {
    Map<Integer, Integer> map;
    int[] f = new int[1000000];
    public FrequencyTracker() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            int occurence = map.get(number);
            map.replace(number, occurence + 1);
            f[occurence]--;
            f[occurence+1]++;
        } else {
            map.put(number, 1);
            f[1]++;
        }
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            if ( map.get(number) > 1) {
                int occurence = map.get(number);
                map.replace(number, occurence - 1);
                f[occurence]--;
                f[occurence-1]++;
            } else {
                map.remove(number);
                f[1]--;
            }
        }
    }

    public boolean hasFrequency(int frequency) { // O(1)
        return f[frequency] > 0;
    }
}
