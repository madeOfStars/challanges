package commons;

public class Node<E> {
    public Node<E> next = null;
    public E data;

    public Node(E data) {
        this.data = data;
    }

    @SafeVarargs
    public Node(E... data) {
        for (E datum : data) {
            append(datum);
        }
    }

    public void append(E data) {
        Node<E> end = new Node<>(data);
        Node<E> node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }
}
