package asu.edu.aravl.medium;

import asu.edu.aravl.utility.ListNode;

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode mainTNode = head;
		ListNode targetNode = null;
        while(mainTNode != null) {
			if(n<=0) {
				if(n==0) {
					targetNode = head;
				}else {
					targetNode = targetNode.next;
				}
			}
			mainTNode = mainTNode.next;
			n--;
		}
		if(targetNode != null) {
            targetNode.next = targetNode.next.next;
        }else if(targetNode == null && n==0) {
        	return targetNode;
        }
		return head;
	}

}
