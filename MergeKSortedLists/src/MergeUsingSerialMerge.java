/*
https://leetcode.com/problems/merge-k-sorted-lists/
 */
import linkedlists.ListNode;

public class MergeUsingSerialMerge {
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tmp = result;

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

        if (l1 != null) {
            result.next = l1;
        }

        if (l2 != null)
            result.next = l2;

        return tmp.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        MergeUsingSerialMerge m = new MergeUsingSerialMerge();

        final ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        final ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        final ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list1 = {
                l1,
                l2,
                l3
        };

        System.out.println(m.mergeKLists(list1));

        ListNode[] list2 = {
                null
        };

        System.out.println(m.mergeKLists(list2));

        ListNode l4 = new ListNode(0);
        l4.next = new ListNode(2);
        l4.next.next = new ListNode(5);

        ListNode[] list3 = {
                l4
        };

        System.out.println(m.mergeKLists(list3));
    }
}
