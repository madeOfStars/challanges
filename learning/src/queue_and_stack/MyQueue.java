/*
https://leetcode.com/problems/implement-queue-using-stacks/
 */
package queue_and_stack;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> primaryStack;
    private final Stack<Integer> secondaryStack;

    private int firstElement;

    public MyQueue() {
        primaryStack = new Stack<>();
        secondaryStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (primaryStack.isEmpty())
            firstElement = x;
        primaryStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondaryStack.isEmpty()) {
            while (!primaryStack.isEmpty())
                secondaryStack.push(primaryStack.pop());
        }
        return secondaryStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return secondaryStack.isEmpty() ? firstElement : secondaryStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return secondaryStack.isEmpty() && primaryStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
