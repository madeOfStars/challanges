import linkedlists.ListNode;

public class Main {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmpFirstNode = head;

        for (int i = 0; i < k; i++) {
            tmpFirstNode = tmpFirstNode.next;
        }
        return null;
    }
}
