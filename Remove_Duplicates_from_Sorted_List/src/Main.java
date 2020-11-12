/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

import linkedlists.ListNode;

public class Main {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentPointer = new ListNode();
        currentPointer.next = head;
        ListNode dummy = currentPointer;

        Integer currVal = null;
        while (head != null) {
            if (currVal == null || currVal != head.val) {
                currVal = head.val;
                currentPointer.next = new ListNode(head.val);
                currentPointer = currentPointer.next;
            }

            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        ListNode x1 = deleteDuplicates(l1);
        ListNode x2 = deleteDuplicates(l2);

        System.out.println(x1);
        System.out.println(x2);
    }
}
