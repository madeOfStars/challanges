public class Main2 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpNodeA = headA;
        ListNode tmpNodeB = headB;

        int a = 0;
        int b = 0;

        while (headA != null) {
            a++;
            headA = headA.next;
        }

        while (headB != null) {
            b++;
            headB = headB.next;
        }

        headA = tmpNodeA;
        headB = tmpNodeB;

        if (a > b) {
            for (int i = b; i < a; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = a; i < b; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l6 = new ListNode(3);
        l6.next = l4;

        ListNode intersectionNode = m.getIntersectionNode(l1, l6);
        System.out.println(intersectionNode);
    }
}
