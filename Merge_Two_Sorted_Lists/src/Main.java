/*
https://leetcode.com/problems/merge-two-sorted-lists/
 */

import linkedlists.ListNode;

public class Main {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummy = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }

            result = result.next;
        }

        if (l1 != null)
            result.next = l1;

        if (l2 != null)
            result.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode l3 = null;
        ListNode l4 = null;

        ListNode l5 = new ListNode(0);

        ListNode output1 = mergeTwoLists(l3, l5);


        while (output1 != null) {
            System.out.println(output1.val);
            output1 = output1.next;
        }
    }
}
