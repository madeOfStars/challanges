/*
https://leetcode.com/problems/copy-list-with-random-pointer/
 */

package amz;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node tmp = head;

        Node copy = new Node(0);
        Node tmpCopy = copy;

        Map<Node, Node> container = new HashMap<>();

        while (head != null) {
            copy.val = head.val;
            copy.next = head.next != null ? new Node(0) : null;
            container.put(head, copy);
            copy = copy.next;
            head = head.next;
        }

        copy = tmpCopy;

        while (tmp != null) {
            tmpCopy.random = container.get(tmp.random);
            tmpCopy = tmpCopy.next;
            tmp = tmp.next;
        }

        return copy;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer m = new CopyListWithRandomPointer();

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        System.out.println(m.copyRandomList(n1));

        Node n6 = new Node(1);
        Node n7 = new Node(2);

        n6.next = n7;
        n6.random = n7;

        n7.random = n7;

//        System.out.println(m.copyRandomList(n6));

        Node n8 = new Node(3);
        Node n9 = new Node(3);
        Node n10 = new Node(3);

        n8.next = n9;
        n9.next = n10;
        n9.random = n8;

//        System.out.println(m.copyRandomList(n8));
    }
}
