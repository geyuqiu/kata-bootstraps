package codility;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // return n lowercase letters (any do not have to be a valid word)
  // #(each letter) % 2 == 1
  public String solution(int N) {
    String result = "";

    // make them to an arraylist
    List<Integer> oddNumbers = new ArrayList<>();
    int sum = 0;
    int nextOddNumber =  findNextOddNumber(N);
    // find next odd number <= N as sum part etc.
    while (sum < N) {
      oddNumbers.add(nextOddNumber);
      sum += nextOddNumber;
      nextOddNumber =  findNextOddNumber(N - sum);
    }

    char[] alphabets = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    for (int i = 0; i < oddNumbers.size(); i++) {
      for (int j = 0; j < oddNumbers.get(i); j++) {
        result += alphabets[i];
      }
    }

    return result;
  }

  private int findNextOddNumber(int n) {
    for (int i = n; i > 0; i--) {
      if (i % 2 == 1 ) return i;
    }
    return -1;
  }
}
