package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestWordCount {
  // lexicographically largest name by tie break
  String largestWordCount(String[] messages, String[] senders) {
    Map<String, Integer> wordsLength = new HashMap<>();

    for (int i = 0; i < senders.length; i++) {
      String sender = senders[i];
      int messageLength = messages[i].split(" ").length;
      if(wordsLength.containsKey(sender)) {
        wordsLength.replace(sender, messageLength + wordsLength.get(sender));
      } else {
        wordsLength.put(sender, messageLength);
      }
    }

    int max = 0;
    String name = "";
    for (Map.Entry<String, Integer> entry: wordsLength.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        name = entry.getKey();
      } else if(entry.getValue() == max && compare(name, entry.getKey())) {
        max = entry.getValue();
        name = entry.getKey();
      }
    }

    return name;
  }

  private boolean compare(String name, String key) {
    return name.compareTo(key) < 0;
  }
}
