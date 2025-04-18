package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PartitionList {

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
     * Two dummy head pointer approach, lets have fun here.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public ListNode partition(ListNode head, int x) {

        ListNode beforeThePivot = new ListNode(0);
        ListNode before = beforeThePivot;

        ListNode afterAndEqualToThePivot = new ListNode(0);
        ListNode after = afterAndEqualToThePivot;

        while(head != null) {
            if (head.val < x) {
                before.next = head;
                before = head;
            } else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }

        before.next = afterAndEqualToThePivot.next;
        after.next = null;

        return beforeThePivot.next;

    }

}
