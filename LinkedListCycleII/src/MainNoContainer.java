/*
https://leetcode.com/problems/linked-list-cycle-ii/
 */

import linkedlists.ListNode;

public class MainNoContainer {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slowPointer = getSlowPointer(head);
        if (slowPointer == null)
            return null;

        ListNode ans = head;

        while (ans != slowPointer) {
            ans = ans.next;
            slowPointer = slowPointer.next;
        }

        return ans;
    }

    private ListNode getSlowPointer(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer)
                return slowPointer;
        }

        return null;
    }

    public static void main(String[] args) {
        MainNoContainer m = new MainNoContainer();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        System.out.println(m.detectCycle(l1).val);
    }
}
