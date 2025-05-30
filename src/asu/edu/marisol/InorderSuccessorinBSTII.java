package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InorderSuccessorinBSTII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    /**
     * Using BST property i.e using val.
     *
     * @time-complexity - O (log n).
     * @space-complexity - O (log n).
     */
    public Node inorderSuccessor(Node node) {

        // Case 1: If the node has right sub-tree, the successor lies there.
        if (node.right != null) {
            Node cur = node.right;
            while (cur.left != null) cur = cur.left;
            return cur;
        }

        // Case 2: No right subtree, go up until you find an ancestor that is a left child.
        Node parent = node.parent;
        while (parent != null && parent.val < node.val)
            parent = parent.parent;

        return parent;
    }

    /**
     * Not using BST property.
     *
     * @time-complexity - O (log n).
     * @space-complexity - O (log n).
     */
    public Node inorderSuccessor2(Node node) {

        // Case 1: If the node has right sub-tree, the successor lies there.
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }

        // Case 2: No right subtree, go up until you find an ancestor that is a left child.
        while (node.parent != null && node.parent.right == node)
            node = node.parent;

        return node.parent;
    }
}
