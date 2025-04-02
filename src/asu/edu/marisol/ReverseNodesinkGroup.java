package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReverseNodesinkGroup {

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
     * Iterative O(1) space approach to reverse in k group, trying an approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ktail = null;

        ListNode cur = head;

        while (cur != null) {
            int count = 0;

            while (count < k && cur != null) {
                cur = cur.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverse(head, k);
                if (newHead != null) newHead = revHead;

                if (ktail != null) ktail.next = revHead;

                ktail = head;
                head = cur;
            }
        }

        if (ktail != null) ktail.next = head;
        // ktail.next is never be non-null, because ktail will always a single detached listNode.


        return newHead == null ? head : newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        ListNode prev = null;
        while (k > 0) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            k--;
        }
        return prev;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;

        while (count < k && cur != null) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            ListNode revHead = reverse(head, k);
            head.next = reverseKGroup2(cur, k);
            return revHead;
        }

        return head;
    }
}
