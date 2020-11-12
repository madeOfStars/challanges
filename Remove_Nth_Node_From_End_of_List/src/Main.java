/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

import linkedlists.ListNode;

public class Main {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode firstPointer = dummy;
        ListNode secondPointer = dummy;

        int counter = 0;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            counter++;

            if (counter > n + 1)
                secondPointer = secondPointer.next;
        }

        secondPointer.next = secondPointer.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1, new ListNode(2));

        ListNode output1 = removeNthFromEnd(l1, 2);
        ListNode output2 = removeNthFromEnd(l2, 1);
        ListNode output3 = removeNthFromEnd(l3, 1);

        int i = 5;
    }
}
