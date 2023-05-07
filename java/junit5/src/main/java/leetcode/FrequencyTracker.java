package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {
    Map<Integer, Integer> f;
    public FrequencyTracker() {
        f = new HashMap<>();
    }

    public void add(int number) { // O(1)
        if (f.containsKey(number)) f.replace(number, f.get(number) + 1);
        else f.put(number, 1);
    }

    public void deleteOne(int number) { // O(1)
        if (f.containsKey(number)) {
            if ( f.get(number) > 1) {
                f.replace(number, f.get(number) - 1);
            } else {
                f.remove(number);
            }
        }
    }

    public boolean hasFrequency(int frequency) { // O(op) takes it short to ask every time ?
        for(Map.Entry<Integer, Integer> entry: f.entrySet()) {
            int occurrence = entry.getValue();
            if (occurrence > 0 && occurrence == frequency ) return true;
        }
        return false;
    }
}
