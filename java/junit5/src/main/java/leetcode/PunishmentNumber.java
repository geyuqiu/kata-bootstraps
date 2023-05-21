package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PunishmentNumber {
    List<List<String>> [] l;
    int punishmentNumber(int n) {
        int[] nums = new int[n+1];
        l = new ArrayList[n+1];
        int punishNumber = 0;
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            l[i] = partitionsContinuousSubstrings(String.valueOf(nums[i] * nums[i]));
            if (substringSumEquals(l[i], nums[i])) {
                punishNumber += nums[i] * nums[i];
            }
        }

        return punishNumber;
    }

    private boolean substringSumEquals(final List<List<String>> lists, final int num) {
        for (int i = 0; i < lists.size(); i++) {
            int sum = 0;
            for (int j = 0; j < lists.get(i).size(); j++) {
                sum += Integer.valueOf(lists.get(i).get(j));
            }
            if (num == sum) return true;
        }
        return false;
    }

    public List<List<String>> partitionsContinuousSubstrings(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partitionHelper(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            currentPartition.add(substring);
            partitionHelper(s, i + 1, currentPartition, result);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }
}
