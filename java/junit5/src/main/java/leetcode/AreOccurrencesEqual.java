package leetcode;

import java.util.HashMap;
import java.util.Map;

public class AreOccurrencesEqual {
    boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();

        for(char c: s.toCharArray()) {
            if (hs.containsKey(c)) {
                hs.replace(c, hs.get(c) + 1);
            } else {
                hs.put(c, 1);
            }
        }

        int times = -1;
        for(Map.Entry<Character, Integer> entry: hs.entrySet()) {
            if (times < 0) times = entry.getValue();
            else if (times != entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
