/*
https://leetcode.com/problems/implement-stack-using-queues/
 */
package queue_and_stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    private final Deque<Integer> q1;
    private final Deque<Integer> q2;
    private int last;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        last = x;
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q2.isEmpty())
            while (!q1.isEmpty())
                q2.add(q1.pollLast());
        return q2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q2.isEmpty() ? last : q2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
