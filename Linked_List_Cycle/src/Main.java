/*
https://leetcode.com/problems/linked-list-cycle/
 */

import linkedlists.ListNode;

public class Main {
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        if (head.next.next == null)
            return false;

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (slowPointer != fastPointer) {
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        System.out.println(hasCycle(l1));
    }
}
