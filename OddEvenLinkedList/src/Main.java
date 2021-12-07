/*
https://leetcode.com/problems/odd-even-linked-list/
 */
public class Main {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = new ListNode();
        ListNode tmpOdd = odd;
        if (head.next == null)
            return head;

        ListNode even = new ListNode();
        ListNode tmpEven = even;

        int sign = 1;

        while (head != null) {
            if (sign == 1) {
                odd.next = new ListNode();
                odd = odd.next;
                odd.val = head.val;
            } else {
                even.next = new ListNode();
                even = even.next;
                even.val = head.val;
            }

            sign *= -1;
            head = head.next;
        }

        odd.next = tmpEven.next;

        return tmpOdd.next;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(m.oddEvenList(l1));

        ListNode l2 = new ListNode(1);
        System.out.println(m.oddEvenList(l2));
    }
}
