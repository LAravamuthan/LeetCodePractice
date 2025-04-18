package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RemoveDuplicatesfromSortedListII {

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
     * My first attempt linear method, O(n) but needs optimization for sure.
     *
     * This solution is faulty due to lack of due diligence from Arav, no duplicate should be present.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public ListNode deleteDuplicates(ListNode head) {

        Integer prevValue = null;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if (prevValue == null || curr.val != prevValue) {
                prevValue = curr.val;
                prev = curr;
            }
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return head;
    }


    /**
     * Optimized prehead method.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public ListNode deleteDuplicates2(ListNode head) {

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        while(head != null) {
            if (head.next != null && head.val == head.next.val) {
                // This if and while loop is super important to skip through all duplicate elements, basically all.
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }

}
