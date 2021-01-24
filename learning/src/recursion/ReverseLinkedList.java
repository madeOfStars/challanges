/*
https://leetcode.com/problems/reverse-linked-list/
 */
package recursion;

public class ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {
        head = reverseList(head, null);
        return head;
    }

    private ListNode reverseList(ListNode currentNode, ListNode nextNode) {
        ListNode newList;

        if (currentNode == null)
            return null;

        if (currentNode.next == null) {
            currentNode.next = nextNode;
            return currentNode;
        }

        newList = reverseList(currentNode.next, currentNode);
        currentNode.next = nextNode;

        return newList;
    }

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(rl.reverseList(l1));
    }
}
