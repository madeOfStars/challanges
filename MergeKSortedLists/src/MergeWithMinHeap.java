/*
https://leetcode.com/problems/merge-k-sorted-lists/
 */
import linkedlists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeWithMinHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new int[]{lists[i].val, i});
                lists[i] = lists[i].next;
            }
        }

        if (pq.isEmpty())
            return null;

        ListNode result = new ListNode();
        ListNode tmp = new ListNode();
        tmp.next = result;

        while (!pq.isEmpty()) {
            final int[] polledValue = pq.poll();
            result.val = polledValue[0];


            if (lists[polledValue[1]] != null) {
                pq.add(new int[]{lists[polledValue[1]].val, polledValue[1]});
                lists[polledValue[1]] = lists[polledValue[1]].next;
            }

            if (!pq.isEmpty()) {
                result.next = new ListNode();
                result = result.next;
            }
        }

        return tmp.next;
    }

    public static void main(String[] args) {
        MergeWithMinHeap m = new MergeWithMinHeap();

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
