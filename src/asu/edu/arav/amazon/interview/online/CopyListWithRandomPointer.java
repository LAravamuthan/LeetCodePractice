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
    


}
