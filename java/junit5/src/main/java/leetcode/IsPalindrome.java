package leetcode;

public class IsPalindrome {
    boolean isPalindrome(int x) {
        String s = x + "";
        String sReverse = new StringBuilder(s).reverse().toString();

        return s.equals(sReverse);
    }
}
