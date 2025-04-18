package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Optimized ring method, god speed my brother.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        ListNode oldTail = head;
        int n = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }

        // now make a circle
        oldTail.next = head;

        ListNode newTail = head;

        // move to new_tail to one but previous to new head
        for (int i = 0; i < n - (k % n) - 1; i++) { // The order precendence matters never use n - (k % n - 1) it fucks up
            newTail = newTail.next;
        }

        // make the new Head
        head = newTail.next;

        // mark the last element in the Linked List.
        newTail.next = null;

        return head;
    }

}
