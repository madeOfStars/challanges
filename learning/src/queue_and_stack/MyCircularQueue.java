package queue_and_stack;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    private List<Integer> data;
    private int size;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        data = new ArrayList<>(k);
        size = k;
        head = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty())
            head++;
        tail = (tail + 1) % size;
        data.add(tail, value);

        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (head == tail)
            head = tail = -1;
        else
            head = (head + 1) % size;

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return data.get(head);
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return data.get(tail);
    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    public boolean isFull() {
        return tail - head == (size - 1) || head - tail == 1;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(2);
        boolean param_1 = obj.enQueue(1);
        boolean param_11 = obj.enQueue(2);
        boolean param_2 = obj.deQueue();
        boolean param_12 = obj.enQueue(3);
        boolean param_21 = obj.deQueue();
        boolean param_13 = obj.enQueue(3);
        boolean param_22 = obj.deQueue();
        boolean param_14 = obj.enQueue(3);
        boolean param_23 = obj.deQueue();
        int param_3 = obj.Front();
        /*int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();*/

        System.out.println(param_1);
        System.out.println(param_11);
        System.out.println(param_2);
        System.out.println(param_12);
        System.out.println(param_21);
        System.out.println(param_13);
        System.out.println(param_22);
        System.out.println(param_14);
        System.out.println(param_23);
        System.out.println(param_3);
    }
}
