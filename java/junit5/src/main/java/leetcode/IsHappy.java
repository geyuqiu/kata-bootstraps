package leetcode;

import java.util.HashSet;

public class IsHappy {
    boolean isHappy(int num) {
        HashSet<Long> hs = new HashSet<>();
        long product;
        long n = num;

        while (true) {
            product = 0;
            long next = n;
            long temp = n;

            while (temp != 0 || next != 0) {
                temp = (long) next % 10;
                next = (long) next / 10;
                product += (long) temp * temp;
            }

            boolean added = hs.add(product);
            if (!added) break;

            n = product;
        }
        if (product == 1) return true;
        return false;
    }
}
