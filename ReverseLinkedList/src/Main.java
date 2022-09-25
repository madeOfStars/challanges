import linkedlists.ListNode;

public class Main {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;

        }

        return null;
    }
}
