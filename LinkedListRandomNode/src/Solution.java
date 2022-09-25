/*
https://leetcode.com/problems/linked-list-random-node/
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private final List<Integer> list = new ArrayList<>();

    public Solution(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        Solution m = new Solution(l1);

        System.out.println(m.getRandom());
    }
}
