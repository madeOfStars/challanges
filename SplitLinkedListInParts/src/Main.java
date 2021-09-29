/*
https://leetcode.com/problems/split-linked-list-in-parts/
 */
import linkedlists.ListNode;

import java.util.Arrays;

public class Main {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int length = 0;

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        while (head != null) {
            length++;
            head = head.next;
        }

        head = dummyHead.next;

        int nrPerBucket = length / k;
        int extraBuckets = length % k;

        for (int i = 0; i < k; i++) {
            ListNode tmpList = new ListNode();
            ListNode tmpHead = tmpList;

            for (int j = 0; j < nrPerBucket && head != null; j++) {
                tmpList.next = new ListNode(head.val);
                head = head.next;
                tmpList = tmpList.next;
            }

            if (extraBuckets > 0 && head != null) {
                tmpList.next = new ListNode(head.val);
                head = head.next;
                extraBuckets--;
            }


            result[i] = tmpHead.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        System.out.println(Arrays.toString(m.splitListToParts(l1, 5)));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next.next = new ListNode(7);
        l2.next.next.next.next.next.next.next = new ListNode(8);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println(Arrays.toString(m.splitListToParts(l2, 3)));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);

        System.out.println(Arrays.toString(m.splitListToParts(l3, 5)));
    }
}
