package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinimumNodeInaBinaryTree {

    /**
     * @algo - custom DFS tree
     * @time-complexity - O(n)
     * @time-complexity - O(log n)
     */
    int min = Integer.MAX_VALUE;
    Integer ans = null;


    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        min = root.val;
        customDfs(root);
        return ans == null ? -1 : ans;
    }

    public void customDfs(TreeNode node) {
        if (node.val > min && (ans == null || node.val < ans)) {
            ans = node.val;
        } else {
            if (node.left != null) customDfs(node.left);
            if (node.right != null) customDfs(node.right);
        }
    }
}
