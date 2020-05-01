package Stack;

import java.util.Stack;

public class _232_ImplementQueueusingStacks {
    /**
     * 232. Implement Queue using Stacks
     *
     */
    /** Initialize your data structure here. 构造函数因为类而不一样*/

    Stack<Integer> s1;
    Stack<Integer> s2;

    public _232_ImplementQueueusingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    // time : O(n);
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()) return s2.pop();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
    }

    // time : O(n);
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        else {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
