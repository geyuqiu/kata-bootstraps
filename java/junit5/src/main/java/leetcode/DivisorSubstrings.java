package leetcode;

public class DivisorSubstrings {
  int divisorSubstrings(int num, int k) {
    // Leading zeros are allowed
    String numStringValue = String.valueOf(num);
    int length = numStringValue.length();
    if (length < k) return 0;
    int kBeauty = 0;

    for (int i = 0; i+k-1 < length; i++) {
      int value = Integer.valueOf(numStringValue.substring(i, i + k));
      if (value == 0) {
        continue;
      }
      if ( num % value == 0) {
        kBeauty++;
      }
    }

    return kBeauty;
  }
}
