package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AddTwoNumbers {

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
     * Add two linked lists .
     *
     * @time-complexity - O (max(n,m)), where n and m is lengths of the LinkedLists to be added.
     * @space-complexity - O (max(n,m)).
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode();
        ListNode preNode = dummyHead;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            preNode.next = new ListNode(sum % 10, null);
            preNode = preNode.next;
            carry = sum / 10;
        }

        return dummyHead.next;

    }

}
