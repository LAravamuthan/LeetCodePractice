package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersinEachNode {
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

    ;


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
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


    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // we assume that at the root level its next pointer has been populated already

        if (root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect2(root.left);
        connect2(root.right);
        return root;
    }

    public Node connect3(Node root) {
        // here we try the iterative method
        // wat we do here is go level by level
        if (root == null) {
            return root;
        }
        Node curlevel = root;
        // while we reach bottom
        while (curlevel != null) {
            // for the current level till the right most node
            Node levelCurNode = curlevel;
            while (levelCurNode != null) {
                if (levelCurNode.right != null) {
                    levelCurNode.left.next = levelCurNode.right;
                    if (levelCurNode.next != null) {
                        levelCurNode.right.next = levelCurNode.next.left;
                    }
                }
                levelCurNode = levelCurNode.next;
            }
            curlevel = curlevel.left;
        }
        return root;
    }


}
