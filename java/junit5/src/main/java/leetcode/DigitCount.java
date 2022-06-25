package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DigitCount {
  boolean digitCount(String num) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < num.length(); i++) {
      char key = num.charAt(i);
      if (map.containsKey(key)) {
        map.replace(key, map.get(key)+1);
      } else {
        map.put(key, 1);
      }
    }

    char c='0';
    for (int i = 0; i < num.length(); i++, c++) {
      char key = num.charAt(i);
      int times = Character.getNumericValue(key);
      if (map.containsKey(c) && map.get(c) != times || !map.containsKey(c) && 0 != times) {
        return false;
      }
    }

    return true;
  }
}
