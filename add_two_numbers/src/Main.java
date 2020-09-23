/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
 */

public class Main {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carriedDigit = 0;
        ListNode output = new ListNode();
        ListNode last = output;

        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carriedDigit;
            last.next = new ListNode(sum % 10);
            carriedDigit = sum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            last = last.next;
        }

        if (carriedDigit > 0) {
            last.next = new ListNode(carriedDigit);
        }
        return output.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1 = new ListNode(2, l1);
        l1 = new ListNode(4, l1);
        l1 = new ListNode(3, l1);

        ListNode l2 = new ListNode();
        l2 = new ListNode(5, l2);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(4, l2);


        ListNode output = addTwoNumbers(l1, l2);

        while (output.next != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
