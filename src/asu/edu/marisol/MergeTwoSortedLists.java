package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergeTwoSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Merge two sorted list.
     *
     * @time-complexity - O (n + m), where n and m is lengths of the LinkedLists to be added.
     * @space-complexity - O (1), just reassigning of pointers.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode preNode = dummyHead;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                preNode.next = list1.val <= list2.val ? list1 : list2;
                if (list1.val <= list2.val) list1 = list1.next;
                else list2 = list2.next;
            } else if (list1 != null) {
                preNode.next = list1;
                list1 = list1.next;
            } else {
                preNode.next = list2;
                list2 = list2.next;
            }
            preNode = preNode.next;
        }

        return dummyHead.next;
    }


    /**
     * Merge two sorted list in smarter way than above.
     *
     * @time-complexity - O (n + m), where n and m is lengths of the LinkedLists to be added.
     * @space-complexity - O (m + n ), for all possible stack frames.
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode preNode = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                preNode.next = list1;
                list1 = list1.next;
            } else {
                preNode.next = list2;
                list2 = list2.next;
            }
            preNode = preNode.next;
        }

        // Once the one of either list1 or list2 has become null, the other one can be directly joined.
        preNode.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else if (list1.val < list2.val){
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }
}
