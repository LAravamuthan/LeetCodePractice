package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PopulatingNextRightPointersinEachNodeII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * Usual way is to do with is to level-order traversal and connect same level elements together. But need to find
     * a solution with O(1) space-complexity.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (1).
     */
    public Node connect(Node root) {
        if (root == null) return null;

        leftMost = root;
        while (leftMost != null) {
            Node curr = leftMost;
            leftMost = null;
            prev = null;
            while (curr != null) {
                if (curr.left != null) processNode(curr.left);
                if (curr.right != null) processNode(curr.right);
                curr = curr.next;
            }
        }

        return root;
    }

    Node leftMost = null;
    Node prev = null;

    private void processNode(Node node) {
        if (prev != null) {
            prev.next = node;
        } else {
            leftMost = node;
        }
        prev = node;
    }

}
