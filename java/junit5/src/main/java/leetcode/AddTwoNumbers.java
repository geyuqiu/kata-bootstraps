package leetcode;

public class AddTwoNumbers {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int val = l1.val  + l2.val;
        int overflow = 0;
        if (l1 != null && l2 != null) {
            if (val >= 10) {
                val =  val - 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            temp = new ListNode(val);
        }
        result = temp;

        while(l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next != null) {
                val = l1.next.val + l2.next.val + overflow;
                if (val >= 10) {
                    val =  val - 10;
                    overflow = 1;
                } else {
                    overflow = 0;
                }
                System.out.println("val: " + val);
                temp.next = new ListNode(val);

                l1 = l1.next;
                l2 = l2.next;
            } else {
                if (l1.next == null && l2.next != null) {
                    val = l2.next.val + overflow;
                    if (val >= 10) {
                        val =  val - 10;
                        overflow = 1;
                    } else {
                        overflow = 0;
                    }
                    temp.next = new ListNode(val);
                    l2 = l2.next;
                } else {
                    val = l1.next.val + overflow;
                    if (val >= 10) {
                        val =  val - 10;
                        overflow = 1;
                    } else {
                        overflow = 0;
                    }
                    temp.next = new ListNode(val);
                    l1 = l1.next;
                }
            }
            temp = temp.next;
        }
        if (overflow != 0) {
            temp.next = new ListNode (1);
        }
        return result;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
