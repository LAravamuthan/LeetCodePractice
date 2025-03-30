package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReverseLinkedList {

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
     * The most important iterative method of reversing list, O(n) approach.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public ListNode reverseList(ListNode head) {

        ListNode prevNode = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }

        return prevNode;
    }

    /**
     * The trickier recursion method of reversing list, the trick is to assume that things are sorted at the current recursion.
     * The base condition is the fact that, at the end return the node (new head) and eact stack frame is pass the same node upwards.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n).
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode p = reverseList2(head.next);
        head.next.next = head;
        // dont miss this step, will cause cycle. The next pointer here will be taken care by the previous stack frame.
        head.next = null;
        return p;
    }
}
