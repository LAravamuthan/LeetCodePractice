package asu.edu.arav.amazon.interview.Trees;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sum-of-left-leaves/
 */


import asu.edu.aravl.utility.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 */


public class SumofLeftLeaves {

    /**
     * @algo - dfs
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, true);
        return sum;
    }

    public void dfs(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
            return;
        }
        if(node.left != null){
            dfs(node.left, true);
        }
        if(node.right != null){
            dfs(node.right, false);
        }
    }
}
