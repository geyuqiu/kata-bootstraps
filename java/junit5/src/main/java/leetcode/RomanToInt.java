package leetcode;

import java.util.AbstractMap;
import java.util.Map;

public class RomanToInt {
    int romanToInt(String roman) {
        int arabic = 0;
        int last = 0;
        for (char c: roman.toCharArray()) {
            int singleArabic = romanToArabic.get(c);

            arabic += last < singleArabic
                    ? singleArabic - 2 * last
                    : singleArabic;
            last = singleArabic;

        }
        return arabic;
    }

    Map<Character, Integer> romanToArabic = Map.ofEntries(
            new AbstractMap.SimpleEntry<Character, Integer>('M', 1000),
            new AbstractMap.SimpleEntry<Character, Integer>('D', 500),
            new AbstractMap.SimpleEntry<Character, Integer>('C', 100),
            new AbstractMap.SimpleEntry<Character, Integer>('L', 50),
            new AbstractMap.SimpleEntry<Character, Integer>('X', 10),
            new AbstractMap.SimpleEntry<Character, Integer>('V', 5),
            new AbstractMap.SimpleEntry<Character, Integer>('I', 1)
    );
}
