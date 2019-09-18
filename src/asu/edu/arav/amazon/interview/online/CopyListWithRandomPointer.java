package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Lint https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    /* First we tried the recursive method of doing it*/

    public Map<Node, Node> newToOldNodeMapping = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (newToOldNodeMapping.containsKey(head)) {
            return newToOldNodeMapping.get(head);
        }
        Node newNode = new Node(head.val, null, null);
        newToOldNodeMapping.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

    /*  Let us see the iterating one */

    public Node getClonedNode(Node node) {
        if (node == null) {
            return null;
        }
        if (newToOldNodeMapping.containsKey(node)) {
            return newToOldNodeMapping.get(node);
        }
        Node newNode = new Node(node.val, null, null);
        newToOldNodeMapping.put(node, newNode);
        return newNode;
    }

    public Node copyRandomListItr(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val, oldNode.next, oldNode.random);
        newToOldNodeMapping.put(oldNode, newNode);
        while (oldNode != null) {
            newNode = getClonedNode(oldNode);
            newNode.next = getClonedNode(oldNode.next);
            newNode.random = getClonedNode(oldNode.random);
            oldNode = oldNode.next;
        }
        return newToOldNodeMapping.get(head);
    }

    /*  Iterative but with O(1) space complexity */

    public Node copyRandomListItrBetter(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node newTemp = new Node(temp.val, null, null);
            newTemp.next = temp.next;
            temp.next = newTemp;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = temp.next;
        while (temp != null) {
            Node tempNode = temp.next;
            temp.next = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next = temp.next.next;
            }
            temp = temp.next;
        }
        return newHead;
    }
}
