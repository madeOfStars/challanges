import linkedlists.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        Set<ListNode> container = new HashSet<>();

        while (head != null) {
            if (container.contains(head))
                return head;

            container.add(head);

            head = head.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        System.out.println(m.detectCycle(l1).val);
    }
}
