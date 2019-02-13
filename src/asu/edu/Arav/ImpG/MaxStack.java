package asu.edu.Arav.ImpG;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {

	Stack<Integer> s1 = new Stack<Integer>();
	
	int top = -1;
	int max = -1;
	private List<Integer> s;

	public MaxStack() {
		s = new ArrayList<Integer>();
		s1.remove(index)
	}

	public void push(int x) {
		if (x <= min) {// if the element is equal or more than the max element this is a candidate of
						// second largest to be used when we pop
			s.add(++top, min);
			min = x;
		}
		s.add(++top, x); // all elements at the next index
	}

	public void pop() {
		if (s.get(top--) == min) {// if the element popped is the largest in the current scenario the element
									// after it is the next largest thereafter
			min = s.get(top--);
		}
	}

	public int top() {
		return s.get(top);
	}
    
    public int peekMax() {
    	return 0;
    }
    
    public int popMax() {
    	return 0;
    }
}
