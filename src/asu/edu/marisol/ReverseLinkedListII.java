package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ReverseLinkedListII {

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
     * Efficient iterative approach, O(n) approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int m = left;
        int n = right;

        ListNode prev = null;
        ListNode cur = head;

        // reach the point where you need to reverse
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode preToRev = prev;
        ListNode tail = cur;

        ListNode temp;
        while (n > 0) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            n--;
        }

        if (preToRev == null) {
            head = prev;
        } else {
            preToRev.next = prev;
        }
        tail.next = cur;

        return head;
    }

    private boolean stop;
    private ListNode left;

    /**
     * Recurvise approach, in this three things to note
     * 1> right pointer is pass by value so that each stack has its own copy and we can backtrack.
     * 2> stop global boolean to make sure we dont swap once the last swap is done.
     * 3> left == right odd size of sublist needs to be reversed and right.next == left happens in the stack when even size of
     * sublist has to be reversed.
     *
     * Above point is (i.e 3rd point) difficult to understand, but look at it this way left only moves forward so common for all
     * stacks, but the backtracked right pointer in a particular stack where it has cross overed or at the mid point needs should not be disturbed
     * at all.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (m) --> difference between left and right.
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        this.left = head;
        this.stop = false;
        recurseReverse(left, right, head);
        return head;
    }


    private void recurseReverse(int m, int n, ListNode right) {
        if (n == 1) return;
        right = right.next;
        if (m > 1) this.left = this.left.next;
        recurseReverse(m - 1, n - 1,right);
        if (this.left == right || this.left == right.next) this.stop = true;
        if (!this.stop) {
            int temp = this.left.val;
            this.left.val = right.val;
            right.val = temp;
            this.left = this.left.next;
        }
    }

}
