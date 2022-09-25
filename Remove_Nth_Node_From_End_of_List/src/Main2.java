import linkedlists.ListNode;

public class Main2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode firstPointer = dummy;
        ListNode secondPointer = dummy;

        int count = 0;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            count++;

            if (count > n + 1) {
                secondPointer = secondPointer.next;
            }
        }

        secondPointer.next = secondPointer.next.next;

        return dummy.next;
    }
}
