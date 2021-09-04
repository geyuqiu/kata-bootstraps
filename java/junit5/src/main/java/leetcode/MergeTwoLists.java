package leetcode;

public class MergeTwoLists {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        ListNode newNode = new ListNode();

        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.val = l1.val;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                l2 = l2.next;
            }
        } else if (l2 == null && l1 != null) {
            newNode.val = l1.val;
            l1 = l1.next;
        } else if (l1 == null && l2 != null){
            newNode.val = l2.val;
            l2 = l2.next;
        }

        newNode.next = mergeTwoLists(l1, l2);
        return newNode;
    }
}
