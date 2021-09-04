package leetcode;

public class Reverse {
    int reverse(int x) {
        int temp = x;
        if (temp< 0) temp = -temp;
        String s = temp+"";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int result = 0;
        try {
            result = Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {

        }

        if (x < 0) result = -result;

        return result;
    }
}
