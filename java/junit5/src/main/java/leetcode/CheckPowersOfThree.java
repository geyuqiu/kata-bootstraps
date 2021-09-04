package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckPowersOfThree {
    Set<Integer> powerOfThrees = new HashSet<>();
    boolean checkPowersOfThree(int n) { // sum of any powers of three
        while(n > 0) {
            int highestPowerof3 = highestPowerof3(n);
            n = n - highestPowerof3;
            if (alreadyChosen(highestPowerof3)) return false;
            powerOfThrees.add(highestPowerof3);
            if (alreadyChosen(n)) return false;
            if ( n== 0 || powerOf3(n)) {
                return true;
            }
        }
        return false;
    }

    private boolean alreadyChosen(int n) {
        return powerOfThrees.contains(n);
    }

    private boolean powerOf3(int n) {
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    int highestPowerof3(int n) {
        int firstPowerOf3 = 1;
        int nextPowerOf3 = 3;
        while (nextPowerOf3 <= n) {
            firstPowerOf3 = nextPowerOf3;
            nextPowerOf3 = nextPowerOf3 * 3;
        }
        return firstPowerOf3;
    }
}
