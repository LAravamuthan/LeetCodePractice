package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PopulatingNextRightPointersinEachNode {

    /**
     * Next pointer usage for iterator.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1), worst case when all the elements are 9, we make a new array altogether.
     */
    public Node connect(Node root) {

        if (root == null) return null;

        Node leftmost = root;
        while (leftmost.left != null) {
            Node node = leftmost;
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null)
                    node.right.next = node.next.left;
                node = node.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }


    /**
     * BFS traversal to connect nodes.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(n).
     */
    public Node connect2(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prev != null)
                    prev.next = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                prev = node;
            }
        }

        return root;
    }


    /**
     * Next pointer usage practice.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public Node connect3(Node root) {
        if (root == null) return root;

        Node levelLeftMost = root;
        while (levelLeftMost.left != null) {
            Node cur = levelLeftMost;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }

            levelLeftMost = levelLeftMost.left;

        }

        return root;
    }

}
