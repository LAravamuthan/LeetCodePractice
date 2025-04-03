package asu.edu.marisol;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergekSortedLists {

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
     * The merge k sorted in divide and conquer.
     *
     * @time-complexity - O (Nlogk) -> N - nodes in the Last list.
     * @space-complexity - O (1).
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int noOfLists = lists.length;
        int interval = 1;
        while (interval < noOfLists) {
            for (int i = 0; i < noOfLists - interval; i += interval * 2) {
               lists[i] = mergeLists(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }
        return noOfLists > 0 ? lists[0] : null;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l1;
                l1 = cur.next.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

    /**
     * The merge k sorted using priority queue.
     *
     * @time-complexity - O (Nlogk) -> N - nodes in the Last list, logk for PQ operations
     * @space-complexity - O (k), at any time there would be k elements in PQ.
     */
    public ListNode mergeKLists2(ListNode[] lists) {
       ListNode dummyHead = new ListNode();
       ListNode cur = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.val < o2.val) return -1;
                    else if (o1.val == o2.val) return 0;
                    else return 1;
                }
        );

        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            if (cur.next.next != null) pq.offer(cur.next.next);
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
