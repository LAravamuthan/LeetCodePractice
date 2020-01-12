package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/deepest-leaves-sum/
 */

public class DeepestLeavesSum {

    int maxDepth = -1;
    int maxDepthSum = -1;

    public int deepestLeavesSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfsStyleSumFinding(root, 0);
        return maxDepthSum;
    }

    public void dfsStyleSumFinding(TreeNode node, int depth) {
        if (depth >= maxDepth) {
            if (depth > maxDepth) {
                maxDepth = depth;
                maxDepthSum = 0;
            }
            maxDepthSum += node.val;
        }
        if (node.left != null) {
            dfsStyleSumFinding(node.left, depth + 1);
        }
        if (node.right != null) {
            dfsStyleSumFinding(node.right, depth + 1);
        }

    }
}
