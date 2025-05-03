package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InsertintoaSortedCircularLinkedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }


    /**
     * Linked list.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }

        Node cur = head;

        while (cur.next != head) {
            if (cur.val <= cur.next.val) {
                if (insertVal >= cur.val && insertVal <= cur.next.val) break;
            } else {
                if (insertVal >= cur.val || insertVal <= cur.next.val) break;
            }
            cur = cur.next;
        }

        Node next = cur.next;
        Node newNode = new Node(insertVal, next);
        cur.next = newNode;

        return head;
    }
}
