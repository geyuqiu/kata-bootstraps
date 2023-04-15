package leetcode;

public class CountAsterisks {
  int countAsterisks(String s) {
    int sum = 0;
    boolean opening = false;
    for (int i = 0; i < s.length(); i++) {
      if (!opening && s.charAt(i) == '*') {
        sum++;
      } else if (opening && s.charAt(i) == '|'){
        opening = false;
      } else if (!opening && s.charAt(i) == '|'){
        opening = true;
      }
    }
    return sum;
  }
}
