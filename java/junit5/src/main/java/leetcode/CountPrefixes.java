package leetcode;

public class CountPrefixes {
  int countPrefixes(String[] words, String s) {
    int m = 0;

    for (int i = 0; i < words.length; i++) {
      if (s.startsWith(words[i])) {
        m++;
      }
    }

    return m;
  }
}
