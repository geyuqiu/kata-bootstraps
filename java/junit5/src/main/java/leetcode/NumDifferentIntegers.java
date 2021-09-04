package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {
    int numDifferentIntegers(String word) {
        String rep = word.replaceAll("[A-Za-z]", " ");

        String[] split = rep.split(" ");

        Set<String> set = new HashSet<>();

        for (String s: split) {
            if (!s.isEmpty()) {
                for (int i=0; i<s.length(); i++){
                    if (s.charAt(i) == '0') {
                        s = s.substring(0,i)+s.substring(i+1);
                        i--;
                    }
                    else  {
                        break;
                    }
                }
                set.add(s);
            }
        }
        return set.size();
    }
}
