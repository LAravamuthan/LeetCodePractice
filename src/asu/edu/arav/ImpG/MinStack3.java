package asu.edu.arav.ImpG;

import asu.edu.AravL.utility.NodeMin;

public class MinStack3 {

	NodeMin head;

	public MinStack3() {
	}

	/*
	 * the push method makes new head node every time , with previous element being
	 * the next Node to head. Each time a push happens the minimum at tht instance is stored
	 * Every time a pop of current smallest element happens 
	 * the head has the information what was minimum when it was pushed
	 * that is enough to give the information regarding smallest element at that instance
	 */

	public void push(int x) {
		if (head == null) {
			head = new NodeMin(x, x, null);
		} else {
			head = new NodeMin(x, Math.min(x, head.min), head);
		}
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.value;
	}

	public int getMin() {
		return head.min;
	}
}
