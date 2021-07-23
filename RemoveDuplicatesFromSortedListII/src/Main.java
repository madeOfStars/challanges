/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
import linkedlists.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode first = head;
        ListNode second = head;

        ListNode temp = new ListNode();
        ListNode result = temp;

        while (first != null) {
            if (!map.containsKey(first.val)) {
                map.put(first.val, 0);
            }

            map.put(first.val, map.get(first.val) + 1);
            first = first.next;
        }

        while (second != null) {
            if (map.get(second.val) == 1) {
                temp.next = new ListNode(second.val);
                temp = temp.next;
            }
            second = second.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);

//        System.out.println(m.deleteDuplicates(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(1);
        l2.next.next.next = new ListNode(2);
        l2.next.next.next.next = new ListNode(3);

//        System.out.println(m.deleteDuplicates(l2));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(2);

        System.out.println(m.deleteDuplicates(l3));
    }
}
