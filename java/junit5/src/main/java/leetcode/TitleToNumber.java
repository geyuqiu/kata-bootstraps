package leetcode;

public class TitleToNumber {
    int titleToNumber(String s) {
        int sum = 0;
        for (int i=s.length()-1, j=0;
             i>=0 && j<s.length();
             i--, j++
        ) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, j);
        }

        return sum;
    }
}
