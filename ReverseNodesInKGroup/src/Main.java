/*
https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
import linkedlists.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();

        ListNode curr = new ListNode();
        ListNode temp = new ListNode();
        temp.next = head;
        curr.next = temp;

        int count = 0;

        while (head != null) {
            stack.add(head);
            queue.add(head);
            head = head.next;
            count++;

            if (count % k == 0) {
                queue.clear();
                while (!stack.empty()) {
                    temp.next = new ListNode(stack.pop().val);
                    temp = temp.next;
                }
            }
        }

        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll().val);
            temp = temp.next;
        }

        return curr.next.next;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(m.reverseKGroup(l1, 1));
    }
}
