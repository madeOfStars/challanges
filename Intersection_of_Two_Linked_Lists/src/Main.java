/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

import linkedlists.ListNode;

public class Main {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;

        int lengthA = 0;
        int lengthB = 0;

        while (headA != null) {
            lengthA++;
            headA = headA.next;
        }

        while (headB != null) {
            lengthB++;
            headB = headB.next;
        }

        int delta = Math.abs(lengthA - lengthB);
        headA = dummyA;
        headB = dummyB;

        if (lengthA > lengthB) {
            for (int i = 0; i < delta; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l6 = new ListNode(3);
        l6.next = l4;

        ListNode intersectionNode = getIntersectionNode(l1, l6);
        System.out.println(intersectionNode);
    }
}
