package leetcode;

class MakeSmallestPalindrome {
    String makeSmallestPalindrome(String s) { // minOps = s.length / 2
        int S = s.length();

        for (int i = S / 2; i < S; i++) {
            if (s.charAt(i) < s.charAt(S - i - 1)) {
                s = s.substring(0, S - i - 1) + s.charAt(i) + s.substring(S - i);
            } else {
                s = s.substring(0, i) + s.charAt(S - i - 1) + s.substring(i + 1);
            }
        }
        return s;
    }
}
