package asu.edu.arav.amazon.interview.leetcode.module.linkedlist;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CopyListwithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            Node clonedNode = new Node(temp.val, null, null);
            clonedNode.next = temp.next;
            temp.next = clonedNode;
            temp = clonedNode.next;
        }

        temp = head;
        while (temp != null) {
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node newClonedNode = temp.next;
        while (temp != null) {
            Node clone = temp.next;
            temp.next = temp.next.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            temp = temp.next;
        }
        return newClonedNode;
    }
}
