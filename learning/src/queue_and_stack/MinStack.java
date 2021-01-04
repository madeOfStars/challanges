/*
https://leetcode.com/problems/min-stack/
 */
package queue_and_stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private final List<Integer> data;
    private final List<Integer> minStack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        data = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        min = Math.min(min, x);
        minStack.add(min);
    }

    public void pop() {
        int last = last();

        data.remove(last);
        minStack.remove(last);

        if (minStack.isEmpty())
            min = Integer.MAX_VALUE;
        else
            min = minStack.get(last - 1);
    }

    public int top() {
        return data.get(last());
    }

    public int getMin() {
        return minStack.get(last());
    }

    private int last() {
        return data.size() - 1;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-10);
        obj.push(14);
        System.out.println(obj.getMin());
        System.out.println(obj.getMin());
        obj.push(-20);
        System.out.println(obj.getMin());
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(10);
        obj.push(-7);
        System.out.println(obj.getMin());
        obj.push(-7);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
    }
}
