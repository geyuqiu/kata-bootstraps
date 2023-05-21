package leetcode;

public class MakeSmallestPalindrome {
    String makeSmallestPalindrome(String s) { // minOps = s.length / 2
        int S = s.length();

        int leftToRight = 0;
        int end = S%2 == 0
                ? S/2
                : S/2 + 1;
        String prefix = s;
        for (int i = 0; i < S/2; i++) {
            if (s.charAt(i) != s.charAt(S-i-1)) {
                leftToRight++;
                prefix = prefix.substring(0, S-i-1) + prefix.charAt(i) + prefix.substring(S-i);
            }
        }

        int rightToLeft = 0;
        String suffix = s;
        for (int i = S-1; i >= end; i--) {
            if (s.charAt(i) != s.charAt(S-i-1)) {
                rightToLeft++;
                suffix = S%2 == 0
                    ? (suffix.substring(0, i-1) + suffix.charAt(i) + suffix.substring(i))
                    : (suffix.substring(0, S-i-1) + suffix.charAt(i) + suffix.substring(S-i));
            }
        }

        return getShortest(leftToRight, prefix, rightToLeft, suffix);
    }

    private static String getShortest(final int leftToRight, final String prefix, final int rightToLeft, final String suffix) {
        if (leftToRight < rightToLeft) {
            return prefix;
        } else if (leftToRight == rightToLeft) {
            int compare = prefix.compareTo(suffix);
            return compare < 0
                    ? prefix
                    : suffix;
        }
        return suffix;
    }
}
