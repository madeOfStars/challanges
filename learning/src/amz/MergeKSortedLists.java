/*
https://leetcode.com/problems/merge-k-sorted-lists/
 */

package amz;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        if (queue.isEmpty())
            return null;

        ListNode tmp = new ListNode();
        ListNode result = new ListNode();
        result.next = tmp;

        while (!queue.isEmpty()) {
            var polledNode = queue.poll();
            tmp.val = polledNode.val;
            polledNode = polledNode.next;

            if (polledNode != null)
                queue.add(polledNode);

            if (!queue.isEmpty()) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();
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
