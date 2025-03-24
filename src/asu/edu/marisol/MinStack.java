package asu.edu.marisol;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinStack {


    /**
     * Storing min and values in stack.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (n).
     */
    private Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int [] { val, val });
        } else {
            stack.push(new int[] {val, Math.min(stack.peek()[1], val) });
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }


    /**
     * Two Stack approach.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (2N) - possibly two
     */
    private Stack<Integer> stack2 = new Stack<>();
    private Stack<Integer> minimum = new Stack<>();

//    public MinStack() {
//        this.stack2 = new Stack<>();
//    }

    public void push2(int val) {
        if(stack2.isEmpty()) {
            minimum.push(val);
        } else if (minimum.peek() > val) {
            minimum.push(val);
        }
        stack2.push(val);
    }

    public void pop2() {
        if (stack2.peek().equals(minimum.peek())) minimum.pop();
        stack.pop();
    }

    public int top2() {
        return stack2.peek();
    }

    public int getMin2() {
        return minimum.peek();
    }

}
