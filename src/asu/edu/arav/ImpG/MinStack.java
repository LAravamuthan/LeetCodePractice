package asu.edu.arav.ImpG;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	/** initialize your data structure here. */
	int top = -1;
	int min = Integer.MAX_VALUE;
	private List<Integer> s;

	public MinStack() {
		s = new ArrayList<Integer>();
	}

	public void push(int x) {
		if (x <= min) {// if the element is equal or less than the min element this is a candidate of
						// second smallest to be used once we pop
			s.add(++top, min);
			min = x;
		}
		s.add(++top, x); // all elements at the next index
	}

	public void pop() {
		if (s.get(top--) == min) {// if the element popped is the smalles in the current scenario the element
									// after it is the next smallest thereafter
			min = s.get(top--);
		}
	}

	public int top() {
		return s.get(top);
	}

	public int getMin() {
		return min;
	}
}
