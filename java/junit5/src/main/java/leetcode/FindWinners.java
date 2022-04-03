package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindWinners {
  List<List<Integer>> findWinners(int[][] matches) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> winnersOnly = new ArrayList<>();
    List<Integer> lostOnce = new ArrayList<>();

    Map<Integer, Boolean> hasOnlyLostOnces = new HashMap<>();
    Set<Integer> players = new HashSet<>();

    for (int[] match: matches) {
      players.add(match[0]);
      players.add(match[1]);
      if (!hasOnlyLostOnces.containsKey(match[1])) {
        hasOnlyLostOnces.put(match[1], true);
      } else if (hasOnlyLostOnces.get(match[1])) {
        hasOnlyLostOnces.replace(match[1], false);
      }
    }

    for (int player: players) {
      if (!hasOnlyLostOnces.containsKey(player)) {
        winnersOnly.add(player);
      }
    }
    result.add(winnersOnly);
    Collections.sort(winnersOnly);

    for (Map.Entry<Integer, Boolean> hasOnlyLostOnce: hasOnlyLostOnces.entrySet()){
      if ((Boolean) hasOnlyLostOnce.getValue()) {
        lostOnce.add(hasOnlyLostOnce.getKey());
      }
    }
    result.add(lostOnce);
    Collections.sort(lostOnce);

    return result;
  }
}
