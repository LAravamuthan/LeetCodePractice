package asu.edu.Arav.ImpG;

import java.util.Stack;

public class MnStack2 {

	/** initialize your data structure here. */
	int min = Integer.MAX_VALUE;
	private Stack<Integer> s;

	public MnStack2() {
		s = new Stack<Integer>();
	}

	public void push(int x) {
		if (x <= min) {// if the element is equal or less than the min element this is a candidate of
						// second smallest to be used once we pop
			s.push(min);
			min = x;
		}
		s.push(x); // all elements at the next index
	}

	public void pop() {
		if (s.pop() == min) {// if the element popped is the smalles in the current scenario the element
									// after it is the next smallest thereafter
			min = s.pop();
		}
	}

	public int top() {
		return s.peek();
	}

	public int getMin() {
		return min;
	}

}
