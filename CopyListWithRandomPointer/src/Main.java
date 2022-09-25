import java.util.HashMap;
import java.util.Map;

public class Main {

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
                    ", next=" + next +
                    ", random=" + random +
                    '}';
        }
    }

    public Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node tmp = dummy;
        Node tmp3 = head;

        while (head != null) {
            dummy.next = new Node(head.val);
            map.put(head.val, dummy.next);
            dummy = dummy.next;
            head = head.next;
        }

        tmp = tmp.next;
        Node tmp2 = tmp;

        while (tmp3 != null) {
            tmp2.random = map.get(tmp.val);
            tmp3 = tmp3.next;
            tmp2 = tmp2.next;
        }

        return tmp2;
    }

    public static void main(String[] args) {
        Main m = new Main();

        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        seven.next = thirteen;
        seven.next.next = eleven;
        seven.next.next.next = ten;
        seven.next.next.next.next = one;

        thirteen.random = seven;
        eleven.random = one;
        ten.random = eleven;
        one.random = seven;

        System.out.println(m.copyRandomList(seven));
    }
}
