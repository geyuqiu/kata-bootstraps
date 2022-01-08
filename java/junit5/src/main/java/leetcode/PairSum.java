package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PairSum {
  int pairSum(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while(head != null) {
      list.add(head.val);
      head = head.next;
    }

    int maxTwinSum = 0;
    for (int i = 0; i < list.size(); i++) {
      int sum = list.get(i) + list.get(list.size() - i - 1);
      maxTwinSum = Math.max(sum, maxTwinSum);
    }

    return maxTwinSum;
  }
}
