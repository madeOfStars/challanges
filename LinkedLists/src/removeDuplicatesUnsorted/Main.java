package removeDuplicatesUnsorted;

import commons.Node;

public class Main {
    public static void main(String[] args) {
        Node<Integer> list = new Node<>(1, 2, 3, 4);
        while (list != null) {
            System.out.println(list.data);
            list = list.next;
        }
    }
}
