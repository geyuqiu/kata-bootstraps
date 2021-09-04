package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestNiceSubstring {
    String longestNiceSubstring(String s) {
        if (s.length() == 1) return "";

        List<String> nice = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            for (int j = i+1; j <s.length()+1; j++) {
                String niceS = s.substring(i, j);
                if (isNice(niceS)) {
                    nice.add(niceS);
                }
            }
        }

        if (nice.size() == 0) return "";

        String longest = nice.get(0);
        for (String str: nice) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }

    private boolean isNice(String niceS) {
        Map<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < niceS.length(); i++) {
            char key = niceS.charAt(i);
            if (!ht.containsKey(key) && !ht.containsKey(toggleCase(key))) ht.put(key, 1);
            if ( ht.containsKey(toggleCase(key))) {
                ht.replace(toggleCase(key), 2);
            }
        }

        for (Map.Entry entry: ht.entrySet()) {
            int value = (int) entry.getValue();
            if (value != 2) {
                return false;
            }
        }

        return true;
    }

    private char toggleCase(char key) {
        if (Character.isLowerCase(key)) return Character.toUpperCase(key);
        return Character.toLowerCase(key);
    }
}
