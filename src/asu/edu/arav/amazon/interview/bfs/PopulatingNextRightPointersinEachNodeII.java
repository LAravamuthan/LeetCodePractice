package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersinEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (i < n - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }


    // left most node in the next level
    public Node leftMost = null;
    // the previously processed node in the next level
    public Node previousInNextLevel = null;


    public void processChild(Node node) {


        if (node != null) {
            if (previousInNextLevel != null) {
                previousInNextLevel.next = node;
            } else {
                leftMost = previousInNextLevel;
            }
            previousInNextLevel = node;
        }
    }

    // T - O(n) and S - O(1)

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        /* Here we process the next level every time assuming that the current and previous levels are
         * already taken care of */

        leftMost = root;
        Node cur = root;
        Node pre = null;

        while (leftMost != null) {
            /* when we start a new level we take help of
             * left most node populated previously while the processing that level
             * so the leftmost will become the current and made null thereafter
             * and previous in next level will also be made null
             */
            cur = leftMost;
            leftMost = null;
            previousInNextLevel = null;
            while (cur != null) {
                processChild(cur.left);
                processChild(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }

}
