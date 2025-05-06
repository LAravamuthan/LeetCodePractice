package asu.edu.marisol;

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

}
