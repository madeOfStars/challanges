import linkedlists.ListNode;

public class Main {
    int length = 0;
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = reverseAll(head);
        k = k % length;

        return null;
    }

    private ListNode reverseAll(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            length++;
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    private ListNode reverseTillK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        int count = 0;

        while (count <= k) {
            count++;
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
