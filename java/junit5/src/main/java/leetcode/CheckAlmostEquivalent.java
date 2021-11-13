package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckAlmostEquivalent {
  boolean checkAlmostEquivalent(String word1, String word2) {
    Map<Character, Integer> word1Occurances = new HashMap<>();
    Map<Character, Integer> word2Occurances = new HashMap<>();

    for (char c: word1.toCharArray()) {
      if (word1Occurances.containsKey(c)) {
        word1Occurances.replace(c, word1Occurances.get(c) + 1);
      } else {
        word1Occurances.put(c, 1);
      }
    }
    for (char c: word2.toCharArray()) {
      if (word2Occurances.containsKey(c)) {
        word2Occurances.replace(c, word2Occurances.get(c) + 1);
      } else {
        word2Occurances.put(c, 1);
      }
    }

    for(Map.Entry<Character, Integer> entry: word1Occurances.entrySet()) {
      Integer occurances = word2Occurances.get(entry.getKey());
      occurances = occurances != null
        ? occurances
        : 0;
      if (Math.abs(entry.getValue() - occurances) > 3) {
        return false;
      }
    }
    for(Map.Entry<Character, Integer> entry: word2Occurances.entrySet()) {
      Integer occurances = word1Occurances.get(entry.getKey());
      occurances = occurances != null
        ? occurances
        : 0;
      if (Math.abs(entry.getValue() - occurances) > 3) {
        return false;
      }
    }

    return true;
  }
}
