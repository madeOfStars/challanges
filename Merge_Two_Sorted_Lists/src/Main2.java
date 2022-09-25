import linkedlists.ListNode;

public class Main2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }

            dummy = dummy.next;
        }

        if (list1 == null) {
            dummy.next = list2;
        }

        if (list1 != null) {
            dummy.next = list1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode l3 = null;
        ListNode l4 = null;

        ListNode l5 = new ListNode(0);

        ListNode output1 = m.mergeTwoLists(l3, l5);


        while (output1 != null) {
            System.out.println(output1.val);
            output1 = output1.next;
        }
    }
}
