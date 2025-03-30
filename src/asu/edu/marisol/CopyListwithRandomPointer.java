package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CopyListwithRandomPointer {


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Efficient approach, O(n) approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node ptr = head;

        // Adding a new node in between
        while (ptr != null) {
            Node newNode = new Node(ptr.val);

            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Attaching the random pointer
        while (ptr != null) {
            ptr.next.random = ptr.random !=null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        ptr = head;

        Node old_ptr = head;
        Node new_ptr = head.next;
        Node new_head = head.next;

        // Unweaving the nodes in between
        while (old_ptr != null) {
            old_ptr.next = old_ptr.next.next;
            new_ptr.next = new_ptr.next != null ? new_ptr.next.next : null;

            old_ptr = old_ptr.next;
            new_ptr = new_ptr.next;
        }

        return new_head;
    }
}
