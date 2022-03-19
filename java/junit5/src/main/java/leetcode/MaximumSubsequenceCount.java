package leetcode;

public class MaximumSubsequenceCount {
  long maximumSubsequenceCount(String text, String pattern) { // O (2*T*T*26)
    int max = 0;
    for (int i = 0; i < pattern.length(); i++) {
      for (int j = 0; j < text.length(); j++) {
        String tempResult = concat(text, pattern.charAt(i), j);
        max = Math.max(findCount(tempResult, pattern), max);
      }
    }
    return max;
  }

  private String concat(String text, char pattern, int j) {
    if (j == 0) return pattern + text;
    else if (j == text.length() - 1) return text + pattern;
    else return text.substring(0, j+1) + pattern + text.substring(j+1);
  }

  int findCount(String s, String pattern) {
    int []freq = new int[26];
    int [][]dp = new int[26][26];
    int x = pattern.charAt(0) - 'a';
    int y = pattern.charAt(1) - 'a';

    for(int i = 0; i < s.length(); ++i) {
      for(int j = 0; j < 26; j++) {
        dp[j][s.charAt(i) - 'a'] += freq[j];
      }
      freq[s.charAt(i) - 'a']++;
    }

    return dp[x][y];
  }
}
