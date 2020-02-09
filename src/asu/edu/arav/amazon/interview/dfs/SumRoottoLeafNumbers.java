package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRoottoLeafNumbers {

    /**
     * @algo - Dfs style tree traversal
     * @time-complexity - O(n)
     * @space-complexity - O(lgn) height of the tree for method heap
     */
    public int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int pathSum) {
        if (node.left == null && node.right == null) {
            res += (pathSum * 10) + node.val;
            return;
        }
        if (node.left != null)
            dfs(node.left, (pathSum * 10) + node.val);
        if (node.right != null)
            dfs(node.right, (pathSum * 10) + node.val);
    }

}
