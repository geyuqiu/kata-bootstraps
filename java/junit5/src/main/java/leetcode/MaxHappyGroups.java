package leetcode;

// understand the recursive solution here https://github.com/geyuqiu/kata-bootstraps/blob/master/java/junit5/src/main/java/crackingTheCodingInterview/listOfStringPermutations.java first :)
public class MaxHappyGroups { // https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
    int maxHappyGroupsBruteForce(int batchSize, int[] groups) { //
        int[] remainders = new int[batchSize];
        for (int numOfCustomer : groups) {
            remainders[numOfCustomer % batchSize]++;
        }
        int happyGroups = remainders[0];
        remainders[0] = 0;
        int ans = remaindersPermutations(0, remainders);

        return ans + happyGroups;
    }

    int remaindersPermutations(int mod, int[] remainders) {
        boolean over = true;
        for (int i = 1; i < remainders.length; i++) {
            if (remainders[i] != 0) {
                over = false;
                break;
            }
        }
        if (over) return 0;

        int firstGroupGetsFreshDonuts = (mod == 0) ? 1 : 0;
        int max = 0;
        for (int i = 1; i < remainders.length; i++) {
            if (remainders[i] > 0) {
                remainders[i]--;
                max = Math.max(max, remaindersPermutations((mod + i) % remainders.length, remainders));
                remainders[i]++;
            }
        }

        return max + firstGroupGetsFreshDonuts;
    }
}

