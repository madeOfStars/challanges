/*
https://leetcode.com/problems/palindrome-linked-list/
 */
import linkedlists.ListNode;

public class Main {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sbLR = new StringBuilder();
        StringBuilder sbRL = new StringBuilder();
        leftRight(head, sbLR);
        rightLeft(head, sbRL);

        return sbLR.toString().equals(sbRL.toString());
    }

    private void leftRight(ListNode head, StringBuilder sb) {
        if (head == null)
            return;

        sb.append(head.val);
        leftRight(head.next, sb);
    }

    private void rightLeft(ListNode head, StringBuilder sb) {
        if (head == null)
            return;

        rightLeft(head.next, sb);
        sb.append(head.val);
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);

        System.out.println(m.isPalindrome(l1));
    }
}
