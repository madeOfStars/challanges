/*
https://leetcode.com/problems/swap-nodes-in-pairs/
 */
package recursion;

public class SwapNodesInPairs {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tmp = new ListNode(head.next.val);
        tmp.next = head;
        head.next = head.next.next;
        head = tmp;
        head.next.next = helper(head.next.next);

        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs sp = new SwapNodesInPairs();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);


        System.out.println(sp.swapPairs(l1));
        System.out.println(sp.swapPairs(l2));
        System.out.println(sp.swapPairs(l3));
    }
}
