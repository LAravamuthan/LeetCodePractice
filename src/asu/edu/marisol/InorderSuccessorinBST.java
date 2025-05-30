package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InorderSuccessorinBST {

    /**
     * Handling the parents and child subtree separately.
     *
     * @time-complexity - O (logn).
     * @space-complexity - O (1).
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // If the right tree is present
        if (p.right != null) {
            TreeNode cur = p.right;
            while (cur.left != null) cur = cur.left;
            return cur;
        }

        // If the p did not have right child, so the answer lies in the parents
        TreeNode successorNode = null;
        while(root != null) {
            if (root.val > p.val) {
                successorNode = root;
                root = root.left;
            }
            else if (root.val < p.val)
                root = root.right;
            else break;
        }

        return successorNode;
    }

    /**
     * Using bst properties for comparison.
     *
     * @time-complexity - O (logN).
     * @space-complexity - O (1).
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode successorNode = null;

        while (root != null) {
            // while the to be searched node is bigger or equal to, go right from current place, these are not potential
            // successors.
            if (p.val >= root.val)
                root = root.right;
            // each element now is a potential answer we need to least successor i.e next successor.
            else {
                successorNode = root;
                root = root.left;
            }
        }

        return successorNode;
    }


    /**
     * Not using BST property
     *
     * @time-complexity - O (logN).
     * @space-complexity - O (1).
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {

        // If the P node has right subtree.
        if (p.right != null) {
            TreeNode cur = p.right;
            while(cur.left != null) cur = cur.left;
            successorNode = cur;
        }
        // if not then do in-order traversal from root and get the successor accordingly.
        else {
            inorder(root, p);
        }

        return successorNode;
    }

    private TreeNode successorNode;
    private TreeNode previousNode;

    private void inorder(TreeNode node, TreeNode p) {
        if (node == null) return;

        inorder(node.left, p);
        if (previousNode == p && successorNode == null) {
            successorNode = node;
            return;
        }
        previousNode = node;
        inorder(node.right, p);
    }






}
