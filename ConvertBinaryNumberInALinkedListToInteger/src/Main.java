/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Main {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(1);

        System.out.println(m.getDecimalValue(l1));
    }
}
