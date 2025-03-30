package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SortList {

    class ListNode {
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
     * Recursion approach for sorting linked list.
     * TODO: Do the iterative approach, interviewers like this a lot.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode prevNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prevNode.next = l1;
                l1 = l1.next;
            } else {
                prevNode.next = l2;
                l2 = l2.next;
            }
            prevNode = prevNode.next;
        }

        prevNode.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    private ListNode findMid(ListNode l1) {
        ListNode preNode = null;
        while(l1 != null && l1.next != null) {
            preNode = preNode == null ? l1 : preNode.next;
            l1 = l1.next.next;
        }

        ListNode mid = preNode.next;
        preNode.next = null;
        return mid;
    }
}
