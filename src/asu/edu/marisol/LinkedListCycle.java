package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Slow and Fast hair approach for finding in Cycle in LinkedList.
     *
     * @time-complexity - O (4^N).
     * @space-complexity - O (N).
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowPtr = head, fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr == fastPtr) return true;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return false;
    }

}
