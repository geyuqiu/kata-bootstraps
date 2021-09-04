package leetcode;

public class MergeInBetween {
    ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int start = 0;
        int end = 0;

        ListNode list1Backup = list1;
        while (list1Backup.next != null && end != b+1) {
            end++;
            list1Backup = list1Backup.next;
        }

        ListNode output = list1Backup;
        while (output != null) {
            System.out.println("list1Backup val: " + output.val);
            output = output.next;
        }


        ListNode tempStart = list1;
        while (tempStart.next != null && start != a - 1) {
            start++;
            tempStart = tempStart.next;
        }
        tempStart.next = list2;

        end = 0;

        ListNode tempEnd = tempStart;
        while (tempEnd.next != null && end != b - a - 1) {
            end++;
            tempEnd = tempEnd.next;
        }

        output = tempEnd;
        while (output.next != null) {
            System.out.println("output val: " + output.val);
            output = output.next;
        }

        output.next = list1Backup;

        return list1;
    }
}
