package asu.edu.marisol;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreeRightSideView {

    class TreeNode {
        int val;
        BinaryTreeRightSideView.TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, BinaryTreeRightSideView.TreeNode left, BinaryTreeRightSideView.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> ans = new ArrayList<>();

    /**
     * Trying depth first search.
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (h) - height of the tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == ans.size()) {
            ans.add(node.val);
        }

        helper(node.right, depth + 1);
        helper(node.left, depth + 1);
    }

    /**
     * Trying depth first search.
     *
     * @time-complexity - O (n), n-> no. of nodes in the Tree.
     * @space-complexity - O (d) - Diameter of the tree.
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> treeQueue = new LinkedList();

        treeQueue.offer(root);
        treeQueue.offer(null); // Sentinel to mark the end of level

        TreeNode curr = root, prev = root;
        List<Integer> rightView = new ArrayList<>();

        // Tree traversal
        while (!treeQueue.isEmpty()) {
            prev = curr;
            curr = treeQueue.poll();
            // Level traversal
            while (curr != null) {
                if (curr.left != null) treeQueue.offer(curr.left);
                if (curr.right != null) treeQueue.offer(curr.right);
                prev = curr;
                curr = treeQueue.poll();
            }

            // Prev at the end of level traversal should be the rightMost.
            rightView.add(prev.val);

            // Mark the end of the level traversal, only if some elements are present in the queue to be viewed
            if (!treeQueue.isEmpty()) treeQueue.offer(null);
        }

        return rightView;
    }
}
